public class BSearchTestDrive
{
	public static void main(String[] args) {
		int[] arr = {2, 5, 7, 8, 3, 0};
		RandSortArray rsa = new RandSortArray(arr);
		int [] a = rsa.getA();
		int result = rsa.binarySearch(0);
		int result1 = rsa.binarySearch(1);
		int result2 = rsa.binarySearch(5);
		int result3 = rsa.binarySearch(6);
		int result4 = rsa.binarySearch(7);
		int result5 = rsa.binarySearch(8);
		int result6 = rsa.binarySearch(888);

		if ( result == 0 
			&& result1 == -1
			&& result2 == 3
			&& result3 == -1
			&& result4 == 4
			&& result5 == 5
			&& result6 == -1
			) {
			System.out.println("Тест успешен");
		} else {
			System.out.println("Неудача");
		}
	}
}