class SimpleDotCom
{
	private int[] locationCells = new int[3];
    private int numOfHits;

    public void setLocationCells(int[] locations) 
    {
        locationCells = locations;
    }

    public String checkUserGuess(String userGuess)
    {
        int guess = Integer.parseInt(userGuess);
        String result = "Мимо";

        for (int cell : locationCells) {
            
            if (guess == cell) {
                result = "Попал";
                //cell = null;
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "Потопил";
        }

        System.out.println(result);
        return result;
    }
}