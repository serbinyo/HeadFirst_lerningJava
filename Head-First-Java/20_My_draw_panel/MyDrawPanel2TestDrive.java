import javax.swing.*;

public class MyDrawPanel2TestDrive
{
    public static void main(String[] args) 
    {
        JFrame gui = new JFrame();
        MyDrawPanel2 panel = new MyDrawPanel2();

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui.getContentPane().add(panel);

        gui.setSize(350, 380);
        gui.setVisible(true);
    }
}