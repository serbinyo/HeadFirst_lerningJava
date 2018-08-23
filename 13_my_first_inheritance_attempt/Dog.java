public class Dog extends Animal
{
    private String name;

    public void setName (String n)
    {
        name = n;
    }

    public String getName ()
    {
        return name;
    }

    public String eat ()
    {
        return "Опять Роял-Канин...Хрум Хрум..";
    }

    public String makeNoise ()
    {
        return "Гав Гав..";
    }

}