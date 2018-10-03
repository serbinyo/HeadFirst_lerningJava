import java.io.*;
import java.net.*;

public class DailyAdviceServer
{
    String[] advices = {"пойти в тренажерку", "поцеловать жену", "поиграть с детьми", 
        "рассказать детям поучительную сказку", "выучить новый алгоритм", 
        "писать код", "сказать жене, что она Самая Лучшая", "делать лабораторки", 
        "заниматься домашними делами", "уделить внимание работе", "проанализировать результаты", 
        "спланировать ближайшее будущее", "расширять поле знаний", "развлечься", 
        "провести время с женой", "изучать теорию программирования"};

    public void go()
    {
        try {

            ServerSocket serverSocket = new ServerSocket(8008);

            while (true) {
                Socket chatSocket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());

                String advice = getAdvice();

                writer.println(advice);

                writer.close();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getAdvice()
    {
        int random = (int) (Math.random() * advices.length);
        return advices[random];
    }

    public static void main(String[] args) 
    {
        new DailyAdviceServer().go();
    }
}