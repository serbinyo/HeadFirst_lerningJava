import java.util.*;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //Создадим несколько сайтов и присвоим им адреса
        DotCom one = new DotCom();
        one.setName("jets.com");
        DotCom two = new DotCom();
        two.setName("pirates.raha");
        DotCom three = new DotCom();
        three.setName("moneta.ru");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель потопить три сайта");
        System.out.println("Игровое поле 7х7: ABCDEFG и 0123456. Размер сайта 3 клетки");
        System.out.println("Попытайтесь справиться за минимальное колличество ходов");

        for (DotCom dotComToSet : dotComList) {
            
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);

        }
    }

    private void startPlaying() 
    {
        while(!dotComList.isEmpty()) {
            
            String userGuess = helper.getUserInput("Введите координаты: ");
            checkUserGuess(userGuess);

        }
        finishGame();
    }

    private void checkUserGuess (String userGuess)
    {
        numOfGuesses++;

        String result = "Мимо";

        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourself(userGuess);

            if (result.equals("Попал")) {
                System.out.println("Вы попали в " + dotComToTest.getName());
                break;
            } else if (result.equals("Потопил")) {
                System.out.println("Вы потопили " + dotComToTest.getName());
                dotComList.remove(dotComToTest);
                break;
            }
        }
        if (result.equals("Мимо")) {
            System.out.println(result);
        }
        
    }

    private void finishGame() 
    {
        System.out.println("Все сайты ушли на дно! Ваши акции теперь ничего не стоят");
        if (numOfGuesses < 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses +" попыток");
            System.out.println("Вы успели вывести свои вложения");
        } else {
            System.out.println("Это заняло у вас довольно много времени: " + numOfGuesses +" попыток");
            System.out.println("Ваши вложения прогорели");
        }
    }

    public static void main(String[] args) 
    {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}