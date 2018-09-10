public class Bottles 
{
    public static void main (String[] args)
    {
        String word = "бутылок (бутылки)";
        int num = 99;

        while (num > 0) {

            if (num == 1) {
                word = "бутылка";
            }

            System.out.println(num + " " + word + " пива на стене");
            System.out.println(num + " " + word + " пива!");
            System.out.println("Возьми одну, пусти по кругу");
            num--;
	}

        System.out.println("Нет бутылок пива на стене");
        System.out.println("Пойди в магазин и стяни ещё!");
    }
}
