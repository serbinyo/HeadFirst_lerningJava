import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.io.*;

public class BeatBox
{
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
        "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", 
        "Cowbell", "Vibrislap", "Low-mid Tom", "Hight Agogo", "Open Hi Contra",};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main (String[] args)
    {
        new BeatBox().buildGUI();
    }

    public void buildGUI()
    {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        checkboxList = new ArrayList<JCheckBox>();

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Старт");
        start.addActionListener(new StartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Стоп");
        stop.addActionListener(new StopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Повысить Темп");
        upTempo.addActionListener(new UpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Понизить Темп");
        downTempo.addActionListener(new DownTempoListener());
        buttonBox.add(downTempo);

        JButton reset = new JButton("Сброс");
        reset.addActionListener(new ResetListener());
        buttonBox.add(reset);

        JButton serialize = new JButton("Сохранить");
        serialize.addActionListener(new SerializeListener());
        buttonBox.add(serialize);

        JButton restore = new JButton("Загрузить");
        restore.addActionListener(new RestoreListener());
        buttonBox.add(restore);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50, 50, 700, 500);
        theFrame.setVisible(true);

    }

    public void setUpMidi()
    {
        try {

            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart()
    {
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {

            trackList = new int[16];
            int key = instruments[i];

            for (int j = 0; j < 16; j++) {

                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16 * i));

                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list)
    {
        for (int i = 0; i < 16; i++){
            int key = list[i];

            if (key != 0){
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return event;
    }

    public class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            buildTrackAndStart();
        }
    }

    public class StopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sequencer.stop();
        }
    }

    public class UpTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class DownTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 0.97));
        }
    }

    public class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for (int i = 0; i < checkboxList.size(); i++) {
                checkboxList.get(i).setSelected(false);
            }
        }
    }

    public class SerializeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean[] checkboxState = new boolean[checkboxList.size()];

            for (int i = 0; i < checkboxList.size(); i++) {

                JCheckBox check = (JCheckBox) checkboxList.get(i);

                if (check.isSelected()) {
                    checkboxState[i] = true;
                } 
            }

            try {

                JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(theFrame);
                File file = chooser.getSelectedFile();

                if (file == null) {return;}

                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(checkboxState);
                oos.close();


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public class RestoreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean[] checkboxState = null;

            try {

                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(theFrame);
                File file = chooser.getSelectedFile();

                if (file == null) {return;}

                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);

                checkboxState = (boolean[]) ois.readObject();
                ois.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка чтения из файла", "Внимание", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (int i = 0; i < checkboxState.length; i++) {

                JCheckBox check = (JCheckBox) checkboxList.get(i);

                if (checkboxState[i]) {
                    check.setSelected(true);
                } else {
                    check.setSelected(false);
                }
            }

            sequencer.stop();
        }
    }


}