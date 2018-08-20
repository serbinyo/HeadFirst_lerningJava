public class GuessGame
{
    Player p1;
    Player p2;
    Player p3;
    int targetNumber;

    public void startGame()
    {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1IsRight = false;
        boolean p2IsRight = false;
        boolean p3IsRight = false;

        targetNumber = (int) (Math.random() * 10);
        System.out.println("Я загадываю число от 0 до 9...");

        while(true){
            System.out.println("Число, которое нужно угадать, - " + targetNumber);

            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Первый игрок думает, что это - " + guessp1);
            
            guessp2 = p2.number;
            System.out.println("Второй игрок думает, что это - " + guessp2);

            guessp3 = p3.number;
            System.out.println("Третий игрок думает, что это - " + guessp3);

            if (guessp1 == targetNumber) {
                p1IsRight = true;
            }

            if (guessp2 == targetNumber) {
                p2IsRight = true;
            }

            if (guessp3 == targetNumber) {
                p3IsRight = true;
            }

            if (p1IsRight || p2IsRight || p3IsRight) {
                System.out.println("У нас есть победитель!");
                System.out.println("Первый игрок угадал? " + p1IsRight);
                System.out.println("Второй игрок угадал? " + p2IsRight);
                System.out.println("Третий игрок угадал? " + p3IsRight);
                System.out.println("Конец игры.");
                break;
            } else {
                System.out.println("Игроки должны попробовать ещё раз.");
            }
        }
    }
}