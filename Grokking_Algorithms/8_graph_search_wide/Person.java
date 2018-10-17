public class Person
{
    private String name;
    private boolean isMangoSeller;

    public Person(String n, boolean ims)
    {
        name = n;
        isMangoSeller = ims;
    }

    public String getName()
    {
        return name;
    }

    public boolean getSeller()
    {
        return isMangoSeller;
    }

    public String toString()
    {
        return name;
    }
}