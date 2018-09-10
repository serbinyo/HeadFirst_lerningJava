public class DogPet extends Dog implements Pet
{
        public String voice (int x)
    {
        String al = "";
        for (int i = 0; i < x; i++) {
            al = al + "Раф..";
        }
        return al;
    }

    public String beNice ()
    {
        return "(тереться о человеческие ноги)";
    }
    
    public String play ()
    {
        return "Таяуу.Таф.Таррр (перевернуться на живот)";
    }
}