import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleChatClientA
{
    JTextArea incoming;
    JTextField outgoing;
    PrintWriter writer;
    Socket socket;
    BufferedReader reader;
    Thread readerThread;

    public static void main(String[] args)
    {
        new SimpleChatClientA().go();
    }

    public void go()
    {
        JFrame frame = new JFrame("Простой чат. Клиент.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(15, 50);
        JScrollPane scroller = new JScrollPane();
        scroller.add(incoming);

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(incoming);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();

        readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.setSize(660, 350);
        frame.setVisible(true);
    }

    private void setUpNetworking()
    {
        try {
            socket = new Socket("127.0.0.1", 8008);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public class SendButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (writer == null) return;

            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public class IncomingReader implements Runnable
    {
        public void run()
        {
            String message;



            try {

                while ((message = reader.readLine()) != null)
                {
                    System.out.println("read: " + message);
                    incoming.append(message + "\n");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}