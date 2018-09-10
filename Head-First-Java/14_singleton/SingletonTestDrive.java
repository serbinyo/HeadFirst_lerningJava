public class SingletonTestDrive
{
    public static void main(String[] args) 
    {
        Singleton s = Singleton.getInstance();
        s.name = "Я один такой!";

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        String result = s1.name + " " + s2.name;

        if (result.equals("Я один такой! Я один такой!")) {
            System.out.println("Пройден");
        } else {
            System.out.println("Неудача");
        }
    }
}