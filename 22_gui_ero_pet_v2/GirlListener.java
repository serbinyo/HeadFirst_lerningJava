import java.awt.event.*;

public class GirlListener implements ActionListener
{
    EroPet eroPet;

    public GirlListener (EroPet ep)
    {
        eroPet = ep;
    }

    public void actionPerformed(ActionEvent e)
    {
        String p = "res/1.jpg";

        if (e.getActionCommand().equals("Сними лифчик")) {
            
            p = "res/2.jpg";

        } else if (e.getActionCommand().equals("Покажи попку")) {

            p = "res/3.jpg";
            
        } else if (e.getActionCommand().equals("Разденься")) {

            p = "res/4.jpg";
            
        } 

        eroPet.doIt(p);  
    }
}