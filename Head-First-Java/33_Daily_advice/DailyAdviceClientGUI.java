import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class DailyAdviceClientGUI
{
    JTextArea display;

    public void go()
    {
        JFrame frame = new JFrame("Получи ежедневный совет");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextArea(6, 19);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);

        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        display.setFont(bigFont);

        JScrollPane scroller = new JScrollPane(display);

        JButton showAdvice = new JButton("Мой совет");
        showAdvice.addActionListener(new AdviceListener());

        JPanel mainPanel = new JPanel();

        mainPanel.add(scroller);
        mainPanel.add(showAdvice);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        frame.setBounds(500, 250, 500, 280);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    
    public static void main(String[] args) 
    {
        new DailyAdviceClientGUI().go();
    }

    public class AdviceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {

            Socket chatSocket = new Socket("127.0.0.1", 8008);

            InputStreamReader isr = new InputStreamReader(chatSocket.getInputStream());

            BufferedReader reader = new BufferedReader(isr);

            String advice = reader.readLine();

            display.setText("Сегодняшний совет: " + advice);

            reader.close();


            } catch (IOException ex) {
                JOptionPane.showMessageDialog(display, "Нет соединения с сервером", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
}