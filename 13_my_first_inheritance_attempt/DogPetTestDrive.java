public class DogPetTestDrive
{
    public static void main(String[] args) 
    {
        DogPet dp = new DogPet();

        if (
            dp.voice(3).equals("Раф..Раф..Раф..")
            && dp.play().equals("Таяуу.Таф.Таррр (перевернуться на живот)")
            && dp.beNice().equals("(тереться о человеческие ноги)")
            ) {
            System.out.println("Тест интерфейса пройден");
        } else {
            System.out.println("Неудача");
        }
    }
}