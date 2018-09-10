import java.io.*;

public class SerializeTest
{
    public static void main(String[] args) 
    {
        GameCharacter ork = new GameCharacter("Орк", "Вадер", 145);
        GameCharacter elf = new GameCharacter("Эльф", "Эйчи", 63);
        GameCharacter vampire = new GameCharacter("Вампир", "Динар", 71);

        try {
            FileOutputStream fos = new FileOutputStream("save.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(ork);
            oos.writeObject(elf);
            oos.writeObject(vampire);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}