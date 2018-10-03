import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class DailyAdviceServerGUI
{
    String[] advices = {"пойти в тренажерку", "поцеловать жену", "поиграть с детьми", 
        "рассказать детям поучительную сказку", "выучить новый алгоритм", 
        "писать код", "сказать жене, что она Самая Лучшая", "делать лабораторки", 
        "заниматься домашними делами", "уделить внимание работе", "проанализировать результаты", 
        "спланировать ближайшее будущее", "расширять поле знаний", "развлечься", 
        "провести время с женой", "изучать теорию программирования"};

    public void go()
    {
        
        drawGUI();

        try {

            ServerSocket serverSocket = new ServerSocket(8008);

            while (true) {
                Socket chatSocket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());

                String advice = getAdvice();

                writer.println(advice);

                writer.close();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getAdvice()
    {
        int random = (int) (Math.random() * advices.length);
        return advices[random];
    }

    public static void main(String[] args) 
    {
        new DailyAdviceServerGUI().go();
    }

    public void drawGUI()
    {
        JFrame frame = new JFrame("Советчик");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        JLabel label = new JLabel("Cервер работает");

        JButton stop = new JButton("Остановить");
        stop.addActionListener(new ExitListener());

        mainPanel.add(label);
        mainPanel.add(stop);
        frame.getContentPane().add(mainPanel);

        frame.setBounds(50, 50, 200, 100);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}