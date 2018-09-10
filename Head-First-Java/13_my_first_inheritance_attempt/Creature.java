abstract public class Creature
{
    private int age;
    private int weight;

    public Creature () 
    {
        System.out.println("Я Creature появился на свет");
    }

    public abstract String eat ();

    public String sleep ()
    {
        return "Хррр ап ап храп..";
    }

    public void setAge (int a)
    {
        age = a;
    }

    public void setWeight (int w)
    {
        weight = w;
    }

    public int getAge ()
    {
        return age;

    }

    public int getWeight ()
    {
        return weight;
    }
}