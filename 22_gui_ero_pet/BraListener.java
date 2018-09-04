import java.awt.event.*;

public class BraListener implements ActionListener
{
    EroPet eroPet;

    public BraListener (EroPet ep)
    {
        eroPet = ep;
    }

    public void actionPerformed(ActionEvent e)
    {
        eroPet.doIt("res/2.jpg");
    }
}