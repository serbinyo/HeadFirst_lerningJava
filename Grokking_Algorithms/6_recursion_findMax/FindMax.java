import java.util.*;

public class FindMax
{
    public int findMax(ArrayList<Integer> arr)
    {

        //Базовый случай
        if (arr.size() == 2) {
            if (arr.get(0) > arr.get(1)) {
                return arr.get(0);
            } else {
                return arr.get(1);
            }
            
        //Рекурсивыный случай
        } else {
            if (arr.get(0) > arr.get(1)) {
                arr.remove(1);
            } else {
                arr.remove(0);
            }
            return findMax(arr);
        }
    }
}