class DogTestDrive
{
    public static void main(String[] args) 
    {
        Dog one = new Dog();
        one.setName("Полкан");
        one.setSize(80);

        Dog two = new Dog();
        two.setName("Вальт");
        two.setSize(25);

        Dog three = new Dog();
        three.setName("Кобальт");
        three.setSize(7);

        one.bark();
        two.bark();
        three.bark();            
    }
}