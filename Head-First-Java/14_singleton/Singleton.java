public class Singleton
{
    public String name;
    private static Singleton instance;

    private Singleton() { }

    public static Singleton getInstance()
    {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}