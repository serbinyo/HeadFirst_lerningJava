import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener
{
    public static void main(String[] args) 
    {
        MiniMusicPlayer2 mp = new MiniMusicPlayer2();
        mp.go();    
    }

    public void go() 
    {
        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWhant = {127};
            sequencer.addControllerEventListener(this, eventsIWhant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61 ; i += 4) {

                track.add(makeEvent(144, 1, i, 100, i));

                track.add(makeEvent(176, 1, 127, 0, i));

                track.add(makeEvent(124, 1, i, 100, i + 2));

            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
    {

        MidiEvent event = null;

        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
            
        } catch (Exception e) {}

        return event;
    }

    public void controlChange(ShortMessage event)
    {
        System.out.println("Ля");
    }
}