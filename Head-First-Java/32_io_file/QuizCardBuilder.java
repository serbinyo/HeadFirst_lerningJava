import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class QuizCardBuilder
{
    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;

    public static void main(String[] args) 
    {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go()
    {
        frame = new JFrame("Quiz Card Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardList = new ArrayList<QuizCard>();

        JPanel mainPanel = new JPanel();

        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        JLabel qLabel = new JLabel("Вопрос: ");

        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel aLabel = new JLabel("Ответ: ");

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Следующая карточка");
        nextButton.addActionListener(new NextCardListener());

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem newMenuItem = new JMenuItem("Новый");
        JMenuItem saveMenuItem = new JMenuItem("Сохранить");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(550,600);
        frame.setVisible(true);
    }

    private void clearCard()
    {
            question.setText("");
            answer.setText("");
            question.requestFocus();
    }

    private void saveFile(File file){

        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (QuizCard card : cardList) {
                    bw.write(card.getQuestion() + "/");
                    bw.write(card.getAnswer() + "\n");
                }
            bw.close();

        } catch (Exception e) {
            System.out.println("Ошибка. Запись карт в файл");
            e.printStackTrace();
        }
        
    }



    public class NextCardListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (!question.getText().equals("") 
                && !answer.getText().equals("") ) {
                cardList.add(new QuizCard(question.getText(), answer.getText()));
                clearCard();
            }
        }
    }

    public class NewMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            cardList.clear();
            clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            if (!question.getText().equals("") 
                && !answer.getText().equals("") ) {
                cardList.add(new QuizCard(question.getText(), answer.getText()));
                clearCard();
            }

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
  
        }
    }
}