import java.util.*;

public class FindMaxTestDrive
{
    public static void main(String[] args) 
    {
        FindMax fm = new FindMax();
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(2);
        arrL.add(4);
        arrL.add(21);
        arrL.add(154);
        arrL.add(15);
        arrL.add(2);

        int result = fm.findMax(arrL);

        if (result == 154) {
            System.out.println("Успешно " + result);
        } else {
            System.out.println("Неудачно, результат: " + result);
        }
    }
}