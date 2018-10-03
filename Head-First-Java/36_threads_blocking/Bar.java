public class Bar implements Runnable
{
    public void run()
    {
        doBar();
    }

    public synchronized void doBar()
    {
        System.out.println("doBar start");
        Foo foo = new Foo();
        foo.doFoo2();
        System.out.println("doBar done");
    }

    public void doBar2()
    {
        System.out.println("doBar2");
    }    
}