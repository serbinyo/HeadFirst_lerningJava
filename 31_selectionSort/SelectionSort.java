import java.util.*;

public class SelectionSort
{
    private ArrayList<Integer> arrLi = new ArrayList<Integer>();
    private ArrayList<Integer> arrOut = new ArrayList<Integer>();
    private int size;
    private int[] result;
    
    public SelectionSort(int[] arr)
    {
        for (int el : arr) {
            arrLi.add(el);
        }
        size = arr.length;
        result = new int [size];
    }

    public int[] getSorted()
    {

        for (int i = 0; i < size; i++) {
            arrOut.add(findMin());
        }

        for (int i = 0; i < size; i++){
            result[i] = arrOut.get(i);
        }

        return result;
    }

    private int findMin()
    {
        int min = arrLi.get(0);
        int min_index = 0;
        for (int i = 0; i < arrLi.size(); i++) {
            if (min > arrLi.get(i)) {
                min = arrLi.get(i);
                min_index = i;
            }
        }
        arrLi.remove(min_index);
        return min;
    }
}