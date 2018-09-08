import java.io.*;

public class UnSerializeTest
{
	public static void main(String[] args) 
    {

        try{

            FileInputStream fis = new FileInputStream("save.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            GameCharacter orkRes = (GameCharacter) ois.readObject();
            GameCharacter elfRes = (GameCharacter) ois.readObject(); 
            GameCharacter vampireRes = (GameCharacter) ois.readObject();

            ois.close();

            System.out.println(orkRes.getCharacterInfo());
            System.out.println("");
            System.out.println(elfRes.getCharacterInfo());
            System.out.println("");
            System.out.println(vampireRes.getCharacterInfo());

        } catch (Exception e) {
            e.printStackTrace();
        }        
	}
}