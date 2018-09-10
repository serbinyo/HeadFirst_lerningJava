public class RandSortArrayTestDrive
{
	public static void main(String[] args) {
		RandSortArray rsa = new RandSortArray(120);
		int [] a = rsa.getA();

		if (a.length == 120
			&& a[1] <= a[10]
			&& a[15] <= a[25]
			&& a[34] <= a[40]
			&& a[55] <= a[99]
			) {
			System.out.println("Тест успешен");
		} else {
			System.out.println("Неудача");
		}
	}
}