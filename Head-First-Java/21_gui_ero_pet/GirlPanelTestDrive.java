import javax.swing.*;

public class GirlPanelTestDrive
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        GirlPanel panel = new GirlPanel("res/2.jpg");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);

        frame.setSize(550, 800);
        frame.setVisible(true);
    }
}