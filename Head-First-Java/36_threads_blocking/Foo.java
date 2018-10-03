public class Foo implements Runnable
{
    public void run()
    {
        doFoo();
    }

    public synchronized void doFoo()
    {
        System.out.println("doFoo start");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            //
        }
        Bar bar = new Bar();
        bar.doBar2();
        System.out.println("doFoo done");
    }

    public void doFoo2()
    {
        System.out.println("doFoo2");
    }

}