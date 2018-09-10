import java.util.*;

public class CountArrElementsTestDrive
{
    public static void main(String[] args) 
    {
        CountArrElements cae = new CountArrElements();
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(2);
        arrL.add(4);
        arrL.add(6);
        arrL.add(8);
        arrL.add(10);
        arrL.add(10);

        int result = cae.count(arrL);

        if (result == 6) {
            System.out.println("Успешно " + result);
        } else {
            System.out.println("Неудачно, результат: " + result);
        }
    }
}