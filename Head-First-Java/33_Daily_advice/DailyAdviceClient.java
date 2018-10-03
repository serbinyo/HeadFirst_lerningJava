import java.io.*;
import java.net.*;

public class DailyAdviceClient
{
    public void go()
    {
        try {

            Socket chatSocket = new Socket("127.0.0.1", 8008);

            InputStreamReader isr = new InputStreamReader(chatSocket.getInputStream());

            BufferedReader reader = new BufferedReader(isr);

            String advice = reader.readLine();

            System.out.println("Сегодняшний совет: " + advice);

            reader.close();


        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) 
    {
        new DailyAdviceClient().go();
    }
}