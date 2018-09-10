import java.util.*;

public class CountArrElements
{
    public int count(ArrayList<Integer> arr)
    {
        if (arr.isEmpty()) {
            return 0;
        } else {
            arr.remove(0);;
            return 1 + count(arr);
        }
    }
}