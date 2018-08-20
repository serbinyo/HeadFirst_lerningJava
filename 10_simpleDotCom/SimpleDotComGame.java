class SimpleDotComGame
{
    public static void main(String[] args) 
    {
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        SimpleDotCom sdc = new SimpleDotCom();

        int randomNum = (int) (Math.random() * 5);

        int [] locations = {randomNum, randomNum + 1, randomNum + 2};

        sdc.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive) {

            String guess = helper.getUserInput("Введите число:");

            String result = sdc.checkUserGuess(guess);

            numOfGuesses++;

            if (result.equals("Потопил")) {

                isAlive = false;

                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");

            }
        }
    }
}