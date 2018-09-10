public class DogTestDrive
{
    public static void main(String[] args) 
    {
        Dog dog1 = new Dog();
        dog1.setName("Филя");
        String noise = dog1.makeNoise();
        String eat = dog1.eat();
        String sleep = dog1.sleep();
        String roam = dog1.roam();

        if (
            dog1.getName().equals("Филя")
            && noise.equals("Гав Гав..")
            && eat.equals("Опять Роял-Канин...Хрум Хрум..")
            && sleep.equals("Хррр ап ап храп..")
            && roam.equals("Хожу-брожу...")

            ) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Неудачно");
        }
    }
}