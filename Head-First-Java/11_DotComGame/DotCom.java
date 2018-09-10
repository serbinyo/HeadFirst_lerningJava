import java.util.ArrayList;

public class DotCom
{
	private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locations) 
    {
        locationCells = locations;
    }

    public void setName(String siteName)
    {
        name = siteName;
    }

    public String getName() {
        return name;
    }

    public String checkYourself(String userGuess)
    {

        String result = "Мимо";

        int index = locationCells.indexOf(userGuess);

        if (index >= 0) {
            locationCells.remove(index);
        
            if (locationCells.isEmpty()) {
                result = "Потопил";
                //System.out.println("Вы потопили " + name);
            } else {
                result = "Попал";
            }
        }

        return result;
    }
}