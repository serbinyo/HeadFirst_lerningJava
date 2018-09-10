public class Human extends Creature
{
    private String sex;
    private String name;

    public Human(String s)
    {
        setSex(s);
        System.out.println("Я Human появился на свет");
    }

    public Human () 
    {
        System.out.println("Я Human появился на свет");
    }

    public String eat () 
    {
        return ("Беру вилку, ложку и ем...");
    }

    public String talk ()
    {
        return "Бла-Бла-Бла...";
    } 

    public String readBook () 
    {
        return "Не охота..посмотрю лучше телек.";
    }

    public void setName (String n)
    {
        name = n;
    }

    public void setSex (String s)
    {
        if (s.equals("male")) {
            sex = "Мужчина";
        } else if (s.equals("female")) {
            sex = "Женщина";
        }
    }

    public String getName ()
    {
        return name;
    }

    public String getSex ()
    {
        return sex;
    }
}