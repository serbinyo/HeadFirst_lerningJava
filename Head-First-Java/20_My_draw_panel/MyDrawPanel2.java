import javax.swing.*;
import java.awt.*;

public class MyDrawPanel2 extends JPanel
{
    public void paintComponent(Graphics g)
    {
        Image image = new ImageIcon("Pirat.jpg").getImage();
        g.drawImage(image, 1, 1, this);
    }
}