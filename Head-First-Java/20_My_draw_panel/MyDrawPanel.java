import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(120, 120, 250, 250);
    }
}