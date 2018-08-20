public class DogsArrayTest
{
    public static void main(String[] args) 
    {
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Барт";

        Dog [] pets = new Dog[3];
        
        pets[0] = new Dog();
        pets[1] = new Dog();
        pets[2] = dog1;

        pets[0].name = "Фред";
        pets[1].name = "Джордж";
        System.out.println ("Имя последней собаки - " + pets[2].name);

        int x = 0;
        while (x < pets.length) {
            pets[x].bark();
            x = x + 1;
        }
    }
}