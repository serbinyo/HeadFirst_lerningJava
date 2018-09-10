import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class QuizCardPlayer
{
    private JFrame frame;
    private JTextArea display;
    private JButton nextButton;
    private JLabel qoaLabel;
    private ArrayList<QuizCard> cardList;
    private int currentCardIndex;
    private boolean isQuestion = true;

    public static void main(String[] args) 
    {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    public void go()
    {
        frame = new JFrame("Quiz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardList = new ArrayList<QuizCard>();

        JPanel mainPanel = new JPanel();

        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        qoaLabel = new JLabel("Вопрос: ");

        display = new JTextArea(6,20);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setFont(bigFont);
        JScrollPane qoaScroller = new JScrollPane(display);
        qoaScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qoaScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Показать ответ");
        nextButton.addActionListener(new NextBtnListener());

        mainPanel.add(qoaLabel);
        mainPanel.add(qoaScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem openMenuItem = new JMenuItem("Открыть");
        openMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(550,400);
        frame.setVisible(true);
    }

    public void loadFile(File file)
    {
        try{

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                makeCard(line);
            }
            reader.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        currentCardIndex = 0;
        isQuestion = true;
        showCard();
    }

    public void makeCard(String line)
    {
        String[] parseResult = line.split("/");
        cardList.add(new QuizCard(parseResult[0], parseResult[1]));
    }

    public void showCard()
    {

        if (cardList.size() < currentCardIndex + 1) return;


        QuizCard card = cardList.get(currentCardIndex);
        if (isQuestion) {
            display.setText(card.getQuestion());
            qoaLabel.setText("Вопрос " + (currentCardIndex + 1));
            nextButton.setText("Показать ответ");
            isQuestion = false;
        } else {
            display.setText(card.getAnswer());
            qoaLabel.setText("Ответ");
            nextButton.setText("Показать вопрос");
            isQuestion = true;
            currentCardIndex++;
        }
    }

    public class OpenMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            cardList.clear();
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(frame);
            loadFile(chooser.getSelectedFile());
        }
    }

        public class NextBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            showCard();
        }
    }
}