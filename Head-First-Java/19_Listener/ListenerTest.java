import javax.swing.*;
import java.awt.event.*;

public class ListenerTest implements MouseListener
{
    JFrame frame;
    JButton button;
    
    public static void main(String[] args) 
    { 
        ListenerTest guiProgramm = new ListenerTest();
        guiProgramm.go();        
    }

    public void go()
    {
        frame = new JFrame();
        button = new JButton("Нажми меня, зайка");

        button.addMouseListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    //public void actionPerformed(ActionEvent event)
    //{
    //    button.setText("Оо, дааааа......");
    //}

    public void mouseClicked(MouseEvent e)
    {
        //
    }

    public void mousePressed(MouseEvent e)
    {
        button.setText("Оо, дааааа......");
    }

    public void mouseReleased(MouseEvent e)
    {
        button.setText("Нажми меня, зайка");
    }

    public void mouseEntered(MouseEvent e)
    {
        //
    }

    public void mouseExited(MouseEvent e)
    {
        //
    }
}