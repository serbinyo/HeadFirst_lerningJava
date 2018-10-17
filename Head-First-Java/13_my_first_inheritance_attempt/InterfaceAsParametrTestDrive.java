public class InterfaceAsParametrTestDrive
{
    public static void main (String[] args)
    {
        new InterfaceAsParametrTestDrive().go();
    }

    public void go()
    {
        HumanFootballer hf1 = new HumanFootballer();
        DogFootballer df1 = new DogFootballer();

        df1.setName("Alex");
        
        showFotballerCelebration(hf1);
        showFotballerCelebration(df1);
    }

    public void showFotballerCelebration (Footballer f)
    {
        System.out.println(f.celebrateGoal(1));
    }
}