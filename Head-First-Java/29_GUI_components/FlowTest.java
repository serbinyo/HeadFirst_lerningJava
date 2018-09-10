import javax.swing.*;
import java.awt.*;

public class FlowTest
{
    public static void main(String[] args) 
    {
        FlowTest ft = new FlowTest();
        ft.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JPanel panel2 = new JPanel();

        JButton btn1 = new JButton("Один раз");
        JButton btn2 = new JButton("и еще два");
        JButton btn3 = new JButton("точно?");
        JButton btn4 = new JButton("О");

        panel.setBackground(Color.darkGray);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel2.add(btn4);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.getContentPane().add(BorderLayout.WEST, panel2);

        frame.setSize(250, 200);
        frame.setVisible(true);
    }
}