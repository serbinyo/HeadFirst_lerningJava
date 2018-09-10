public class FactorialTestDrive
{
    public static void main(String[] args) 
    {
        int result = Factorial.factorial(10);

        if (result == 3628800) {
            System.out.println("Успешно");
        } else {
            System.out.println("Неудача");
        }
    }
}