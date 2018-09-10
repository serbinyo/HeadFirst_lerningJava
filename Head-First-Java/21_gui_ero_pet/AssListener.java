import java.awt.event.*;

public class AssListener implements ActionListener
{
    EroPet eroPet;

    public AssListener (EroPet ep)
    {
        eroPet = ep;
    }

    public void actionPerformed(ActionEvent e)
    {
        eroPet.doIt("res/3.jpg");
    }
}