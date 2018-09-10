import java.awt.event.*;

public class NackedListener implements ActionListener
{
    EroPet eroPet;

    public NackedListener (EroPet ep)
    {
        eroPet = ep;
    }

    public void actionPerformed(ActionEvent e)
    {
        eroPet.doIt("res/4.jpg");
    }
}