import javax.swing.*;

public class MyDrawPanel3TestDrive
{
    public static void main(String[] args) 
    {
        JFrame gui = new JFrame();
        MyDrawPanel3 panel = new MyDrawPanel3();

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui.getContentPane().add(panel);

        gui.setSize(350, 380);
        gui.setVisible(true);
    }
}