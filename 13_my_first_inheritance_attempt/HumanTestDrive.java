public class HumanTestDrive
{
    public static void main(String[] args) 
    {
        Human h = new Human("female");
        Human h2 = new Human();
        h.setWeight(75);
        h.setAge(21);
        h.setName("Дора");

        
        if (
            h.getName().equals("Дора")
            && (h.getWeight() == 75)
            && (h.getAge() == 21)
            && h2.talk().equals("Бла-Бла-Бла...")
            && h2.readBook().equals("Не охота..посмотрю лучше телек.")
            && h2.eat().equals("Беру вилку, ложку и ем...")
            && h2.sleep().equals("Хррр ап ап храп..")
            ) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Неудачно");
        }
    }
}