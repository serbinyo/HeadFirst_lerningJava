public class ConstructTestDrive
{
    public static void main (String[] args)
    {
        HumanFootballer hf = new HumanFootballer();
        System.out.println(hf.getSex());
        hf = null;
    }
}