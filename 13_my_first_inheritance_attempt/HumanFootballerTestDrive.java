public class HumanFootballerTestDrive
{
    public static void main(String[] args) 
    {
        HumanFootballer hf = new HumanFootballer();

        if (
            hf.train().equals("Потренировался")
            && hf.playFootbal().equals("Играть матч")
            && hf.celebrateGoal(2).equals("Сальто..Сальто..")
            ) {
            System.out.println("Тест интерфейса пройден");
        } else {
            System.out.println("Неудача");
        }
    }
}