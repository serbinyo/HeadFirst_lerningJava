import java.util.*;
import static java.lang.System.out;

public class FullMons
{
    static int DAY_IM = 
    60 * 60 * 1000                  //a hour in millisecconds
    * 24;                           //a day in millisecconds

    public static void main(String[] args) 
    {
        Calendar c = Calendar.getInstance();
        c.set(2018, 6, 26, 15, 40);
        long day1 = c.getTimeInMillis();

        for (int x = 0; x < 120; x++) {
            day1 += DAY_IM * 29.52;
            c.setTimeInMillis(day1);
            out.println(
                String.format
                ("Полнолуние будет в %tc", c.getTime())
                );
        }
    }
}