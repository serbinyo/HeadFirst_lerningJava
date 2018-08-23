public class WrapTest
{
    Integer integer;
    int i;

    public static void main(String[] args) 
    {
        WrapTest wt = new WrapTest();
        wt.go();
    }

    public void go()
    {
        i = integer; //java.lang.NullPointerException
    }
}