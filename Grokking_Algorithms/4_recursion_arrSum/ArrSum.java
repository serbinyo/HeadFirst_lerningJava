import java.util.*;

public class ArrSum
{
    public int sum(ArrayList<Integer> arr)
    {
        if (arr.size() == 1) {
            return arr.get(0);
        }
        int x = arr.get(0);
        arr.remove(0);
        return x + sum(arr);
    }
}