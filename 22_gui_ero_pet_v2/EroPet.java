import javax.swing.*;
import java.awt.*;

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

        GirlListener braListener = new GirlListener(this);
        GirlListener nackedListener = new GirlListener(this);
        GirlListener assListener = new GirlListener(this);
        GirlListener dressListener = new GirlListener(this);

        braBtn.addActionListener(braListener);
        nackedBtn.addActionListener(nackedListener);
        assBtn.addActionListener(assListener);
        dressBtn.addActionListener(dressListener);

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
}