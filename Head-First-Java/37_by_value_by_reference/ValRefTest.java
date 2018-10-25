public class ValRefTest
{
    String name = "Serbin";
    int age = 30;

    public static void main(String[] args) 
    {
        new ValRefTest().test();
    }

    public void fullName(String n) 
    {
        n += " Alexandr";
        System.out.println("Вывод в функции name:");
        System.out.println(n);
    }

    public void addAge(int a) 
    {
        a++;
        System.out.println("Вывод в функции age:");
        System.out.println(a);
    }

    public void editPerson(Person p)
    {
        p.name += " Kirill";
        System.out.println("Вывод в функции person:");
        System.out.println(p.name);
    }

    public void test()
    {
        Person person = new Person();
        person.name = "Reva";

        fullName(name);
        addAge(age);
        editPerson(person);

        System.out.println("Вывод в классе ");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("person: " + person.name);
    }
}