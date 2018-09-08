import java.io.*;

public class GameCharacter implements Serializable
{
    private String race;
    private String name;
    private int weight;
    public Weapon weapon;

    public GameCharacter(String r, String n, int w)
    {
        race = r;
        name = n;
        weight = w;
        weapon = new Weapon();
    }

    public void setRace(String r)
    {
        race = r;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setWeigth(int w)
    {
        weight = w;
    }

    public void setWeapon(String n, int d)
    {
        weapon.setName(n);
        weapon.setDamage(d);
    }

    public String getRace()
    {
        return race;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

        public String getWeaponInfo()
    {
        String wpnInfo = weapon.getName() + " - Урон " + weapon.getDamage() + " единиц.";
        return wpnInfo;
    }

    public String getCharacterInfo()
    {
        String carInfo = getName() + " - " + getRace() + ". Вес: " + getWeight() 
        + "кг.\n" + "Оружие: " + getWeaponInfo();
        return carInfo;
    }
}