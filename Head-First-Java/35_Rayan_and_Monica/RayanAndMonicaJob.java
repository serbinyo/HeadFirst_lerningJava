class BankAccount
{
    private int balance = 100;

    public int getBalance()
    {
        return balance;
    }

    public void withDraw (int amount)
    {
        balance =- amount;
    }
}

public class RayanAndMonicaJob implements Runnable
{
    private BankAccount account = new BankAccount();

    public static void main(String[] args) 
    {
        RayanAndMonicaJob job = new RayanAndMonicaJob();
        Thread one = new Thread(job);
        Thread two = new Thread(job);
        one.setName("Райан");
        two.setName("Моника");
        one.start();
        two.start();
    }

    public void run()
    {
        for (int i = 0; i < 10; i++) {
            makeWithDraw(10);
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита");
            }
        }
    }

    private synchronized void makeWithDraw(int amount)
    {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            try {
                System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " просыпается");
            account.withDraw(amount);
            System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию");
        } else {
            System.out.println("Для клиента " + Thread.currentThread().getName() + " недостаточно денег");
        }
    }
}