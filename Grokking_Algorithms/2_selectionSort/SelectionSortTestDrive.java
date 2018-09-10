public class SelectionSortTestDrive
{
    public static void main(String[] args) 
    {
        SelectionSort selectionSort = new SelectionSort(new int[] {154, 698, 24, 337, 1, 47, 555, 555, 4});
        int[] sortedArray = selectionSort.getSorted();

        boolean success = true;


        for (int i = 0; i < sortedArray.length-1; i++) {
            if (sortedArray[i] > sortedArray[i+1]) {
                success = false;
                break;
            }
        }

        if (sortedArray.length < 2) success = false;

        if (success) {
            System.out.println("Тест успешен");
        } else {
            System.out.println("Неудача");
        }
    }
}