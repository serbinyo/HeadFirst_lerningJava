import java.awt.event.*;

public class DressListener implements ActionListener
{
    EroPet eroPet;

    public DressListener (EroPet ep)
    {
        eroPet = ep;
    }

    public void actionPerformed(ActionEvent e)
    {
        eroPet.doIt("res/1.jpg");
    }
}