public class DogFootballer extends Dog implements Footballer
{
    public DogFootballer ()
    {
        System.out.println("Я DogFootballer появился на свет");
    }

    public String train ()
    {
        return "Гррр....брррр (тренировка)";
    }

    public String playFootbal ()
    {
        return "Аффф.....гррр..ххрааффф (игра)";
    }

    public String celebrateGoal (int x)
    {
        String flip = "";

        for (int i = 0; i < x ; i++) {
            flip = flip + "Проходка на задних лапах..";            
        }

        return flip;
    }
}