import java.util.ArrayList;

class DotComTestDrive
{
    public static void main(String[] args) 
    {
        DotCom sdc = new DotCom();
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("2");
        locations.add("3");
        locations.add("4");
        sdc.setLocationCells(locations);

        String userGuess = "2";

        String result = sdc.checkYourself(userGuess);

        String testResult = "Неудача";

        if (result.equals("Попал")) {
            testResult = "Пройден";
        }

        System.out.println(testResult);        
    }
}