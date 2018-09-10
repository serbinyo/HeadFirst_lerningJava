import javax.swing.*;
import java.awt.*;

public class Animation
{
    int x = 20;
    int y = 50;

    public static void main(String[] args) 
    {
        Animation anima = new Animation();
        anima.go(); 
    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panel);



        frame.setSize(400,500);
        frame.setVisible(true);

        for (int i = 0; i < 250; i++) {
            x += 1;
            y += 1;
            frame.repaint();

            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    class MyDrawPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.orange);
            g.fillOval(x, y, 100, 100);
        }
    }
}