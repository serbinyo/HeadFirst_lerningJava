import javax.swing.*;
import java.awt.*;

public class GirlPanel extends JPanel
{
    private String path;

    public GirlPanel(String p)
    {
        path = p;
    }

    public void paintComponent(Graphics g)
    {
        Image girlImage = new ImageIcon(path).getImage();

        g.drawImage(girlImage, 0, 0, this);
    }

    public void setPath (String p)
    {
        path = p;
    }

}