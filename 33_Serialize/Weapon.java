import java.io.*;

public class Weapon implements Serializable
{
    private String name;
    private int damage;

    public Weapon()
    {
        name = "Меч";
        damage = 10;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setDamage(int d)
    {
        damage = d;
    }

    public String getName()
    {
        return name;
    }

    public int getDamage()
    {
        return damage;
    }
}