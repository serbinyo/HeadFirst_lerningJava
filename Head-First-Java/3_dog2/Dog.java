class Dog 
{
    private String name;
    private int size;

    public void bark ()
    {
        if (size > 60) {
            System.out.println (name + " прогремел - Гав! Гав!");
        } else if (size > 14) {
            System.out.println (name + " полаял - Раф! Раф!");
        } else {
            System.out.println (name + " пропищал - Тяф! Тяф!");
        }
        
    }

    public void setName (String a)
    {
        name = a;
    }

    public String getName ()
    {
        return name;
    }

        public void setSize (int b)
    {
        size = b;
    }

    public int getSize ()
    {
        return size;
    }
}