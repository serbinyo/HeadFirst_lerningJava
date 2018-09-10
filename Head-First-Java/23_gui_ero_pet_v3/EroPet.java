import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EroPet
{
    JFrame frame;
    GirlPanel girl;

    public static void main(String[] args) 
    {
        EroPet eroPet = new EroPet();
        eroPet.go();
    }

    public void go()
    {
        frame = new JFrame();
        girl = new GirlPanel("res/1.jpg");

        JButton braBtn = new JButton("Сними лифчик");
        JButton nackedBtn = new JButton("Разденься");
        JButton assBtn = new JButton("Покажи попку");
        JButton dressBtn = new JButton("Оденься");

        braBtn.addActionListener(new BraListener());
        nackedBtn.addActionListener(new NackedListener());
        assBtn.addActionListener(new AssListener());
        dressBtn.addActionListener(new DressListener());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(BorderLayout.CENTER, girl);
        frame.getContentPane().add(BorderLayout.SOUTH, assBtn);
        frame.getContentPane().add(BorderLayout.EAST, nackedBtn);
        frame.getContentPane().add(BorderLayout.NORTH, braBtn);
        frame.getContentPane().add(BorderLayout.WEST, dressBtn);

        frame.setSize(750, 850);
        frame.setVisible(true);

    }

    public void doIt (String p)
    {
        girl.setPath(p);
        frame.repaint();
    }

    class DressListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doIt("res/1.jpg");
        }
    }

    class BraListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doIt("res/2.jpg");
        }
    }

    class AssListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doIt("res/3.jpg");
        }
    }

    class NackedListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doIt("res/4.jpg");
        }
    }
}