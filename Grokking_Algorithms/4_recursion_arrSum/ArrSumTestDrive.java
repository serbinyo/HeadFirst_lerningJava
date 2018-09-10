import java.util.*;

public class ArrSumTestDrive
{
    public static void main(String[] args) 
    {
        ArrSum as = new ArrSum();
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(2);
        arrL.add(4);
        arrL.add(6);
        arrL.add(8);
        arrL.add(10);
        arrL.add(10);

        int result = as.sum(arrL);

        if (result == 40) {
            System.out.println("Успешно");
        } else {
            System.out.println("Неудачно, результат: " + result);
        }
    }
}