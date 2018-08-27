import java.util.*;

public class RandSortArray
{
	private int [] arr;

	public RandSortArray () 
	{
		arr = new int [100];
		arr = fillArray(arr);
		Arrays.sort(arr);
	}

	public RandSortArray (int x) 
	{
		arr = new int [x];
		arr = fillArray(arr);
		Arrays.sort(arr);
	}

	public RandSortArray (int [] x) 
	{
		arr = x;
		Arrays.sort(arr);
	}

	private int [] fillArray(int [] a)
	{
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		return a;
	}

	public int binarySearch(int x)
	{
		int first = 0;
		int last = arr.length - 1;
		int mid;
		int guess;

		while (last >= first) {
			mid = (first + last) / 2;
			guess = arr[mid];

			if (guess == x) {
				return mid;
			}
			if (guess > x) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}
		return -1;
	}

	public int [] getA()
	{
		return arr;
	}
}