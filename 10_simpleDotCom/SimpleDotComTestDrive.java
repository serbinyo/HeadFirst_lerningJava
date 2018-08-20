class SimpleDotComTestDrive
{
    public static void main(String[] args) 
    {
        SimpleDotCom sdc = new SimpleDotCom();
        int[] locations = {2, 3, 4};
        sdc.setLocationCells(locations);

        String userGuess = "4";

        String result = sdc.checkUserGuess(userGuess);

        String testResult = "Неудача";

        if (result.equals("Попал")) {
            testResult = "Пройден";
        }

        System.out.println(testResult);        
    }
}