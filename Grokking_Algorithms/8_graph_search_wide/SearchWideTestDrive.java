public class SearchWideTestDrive
{
    public static void main (String[] args)
    {
        SearchWide sw = new SearchWide();
        Person result = sw.go("You");

        if (result != null) {
            String seller = result.getName();
            if (seller.equals("Thom")) {
                System.out.println("Тест успешно выполнен\nПродавец " + seller);
            } else {
                System.out.println("Тест провален");
            }
        } else {
            System.out.println("Продавцов манго не нашлось");
        }
    }
}