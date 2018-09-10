public class HumanFootballer extends Human implements Footballer
{
    public HumanFootballer ()
    {
        super("male");
        System.out.println("Я HumanFootballer появился на свет");
    }

    public String train ()
    {
        return "Потренировался";
    }

    public String playFootbal ()
    {
        return "Играть матч";
    }

    public String celebrateGoal (int x)
    {
        String flip = "";

        for (int i = 0; i < x ; i++) {
            flip = flip + "Сальто..";            
        }

        return flip;
    }
}