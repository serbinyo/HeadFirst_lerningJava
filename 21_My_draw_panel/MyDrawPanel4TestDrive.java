import javax.swing.*;

public class MyDrawPanel4TestDrive
{
    public static void main(String[] args) 
    {
        JFrame gui = new JFrame();
        MyDrawPanel4 panel = new MyDrawPanel4();

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui.getContentPane().add(panel);

        gui.setSize(350, 380);
        gui.setVisible(true);
    }
}