public class ThreadsBlockingTest
{
    public static void main (String[] arg)
    {
        Foo fooJob = new Foo();
        Bar barJob = new Bar();
        Thread one = new Thread(fooJob);
        Thread two = new Thread(barJob);
        one.start();
        two.start();
    }
}