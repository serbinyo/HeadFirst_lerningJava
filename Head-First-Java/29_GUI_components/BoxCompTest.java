import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoxCompTest
{

    public JFrame frame;
    public JTextArea textArea;

    public static void main(String[] args) 
    {
        BoxCompTest bc = new BoxCompTest();
        bc.go();
    }

    public void go()
    {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelMain = new JPanel();
        JPanel panelVert = new JPanel();
        panelVert.setLayout(new BoxLayout(panelVert, BoxLayout.Y_AXIS));

        
        //Components: buttons
        JButton btn = new JButton("Один раз");
        btn.addActionListener(new TextAreaOneListener());
        JPanel panelBtn = new JPanel();
        panelBtn.add(btn);

        JButton btn1 = new JButton("Десять раз");
        btn1.addActionListener(new TextAreaTenListener());
        JPanel panelBtn1 = new JPanel();
        panelBtn1.add(btn1);

        //Components: textArea with scroller
        JPanel textScrollPanel = new JPanel();
        textArea = new JTextArea(10, 20);
        textArea.setLineWrap(true);
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textScrollPanel.add(scroller);

        //Components: text field with label
        JPanel panelTextField = new JPanel();
        JLabel labelText = new JLabel("Вводите текст тут:");
        JTextField textField = new JTextField(20);
        panelTextField.add(labelText);
        panelTextField.add(textField);

        //Components: three checkboxes in line
        JPanel panelCheckboxes = new JPanel();
        JCheckBox cb1 = new JCheckBox("Вариант 1");
        JCheckBox cb2 = new JCheckBox("Вариант 2");
        JCheckBox cb3 = new JCheckBox("Не вариант");
        panelCheckboxes.add(cb1);
        panelCheckboxes.add(cb2);
        panelCheckboxes.add(cb3);

        //Components: list with scroll
        JPanel panelList = new JPanel();
        String [] food = {
            "помидор",
            "огурец",
            "хлеб",
            "мука",
            "яблоко",
            "колбаса",
            "соус греческий",
            "базилик",
            "какао",
            "сметана",
            "ром",
            "говядина",
            "сыр",            
        };
        JList<String> listFood = new JList<String>(food);
        listFood.setVisibleRowCount(5);
        JScrollPane scrolList = new JScrollPane(listFood);
        scrolList .setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrolList .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrolList.add(panelList);


        //Assemble virtical panel
        panelVert.add(panelBtn);
        panelVert.add(panelBtn1);
        panelVert.add(textScrollPanel);
        panelVert.add(panelTextField);
        panelVert.add(panelCheckboxes);
        panelVert.add(scrolList);

        panelMain.setBackground(Color.darkGray);
        panelMain.add(panelVert);     
        frame.getContentPane().add(BorderLayout.CENTER, panelMain);

        frame.setSize(500, 750);
        //frame.pack();
        frame.setVisible(true);

    }

    public class TextAreaOneListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae){
            textArea.append("один раз \n");
            frame.repaint();
        }   
    }

        public class TextAreaTenListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae){

            for (int i = 0; i < 10; i++) {
                textArea.append("один раз \n");
            }
         
            frame.repaint();
        }   
    }
}