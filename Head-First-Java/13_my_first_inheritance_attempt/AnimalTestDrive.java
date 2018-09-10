public class AnimalTestDrive
{
    public static void main(String[] args) 
    {
        A anml = new A();
        String roam = anml.roam();

        if (roam.equals("Хожу-брожу...")) {
            System.out.println("Пройден");
        } else {
            System.out.println("Неудача");
        }
    }
}

class A extends Animal
{
    public String makeNoise ()
    {
        return "";
    }

    public String eat ()
    {
        return "";
    }
}