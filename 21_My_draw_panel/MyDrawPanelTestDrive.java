import javax.swing.*;

public class MyDrawPanelTestDrive
{
    public static void main(String[] args) 
    {
        JFrame gui = new JFrame();
        MyDrawPanel panel = new MyDrawPanel();

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui.getContentPane().add(panel);

        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}