import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons
{
    JFrame frame;
    JLabel lable;

    public static void main(String[] args) 
    {
        TwoButtons tb = new TwoButtons();
        tb.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lable = new JLabel("I'm the lable");
        DrawPanel panel = new DrawPanel();

        JButton panelButton = new JButton("Change panel");
        JButton labelButton = new JButton("Change lable");

        panelButton.addActionListener(new PanelListener());
        labelButton.addActionListener(new LabelListener());

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.WEST, lable);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.SOUTH, panelButton);


        frame.setSize(550, 380);
        frame.setVisible(true);
    }

    class PanelListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            frame.repaint();
        }
    }

    class LabelListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            lable.setText("Changed      ");
        }
    }
}