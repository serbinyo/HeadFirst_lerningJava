public class GameCharacterTestDrive
{
    public static void main(String[] args) 
    {
        GameCharacter ork = new GameCharacter("Орк", "Вадер", 145);
        String orkResult = ork.getCharacterInfo();

        GameCharacter elf = new GameCharacter("Эльф", "Эйчи", 63);
        elf.setWeapon("Лук", 9);
        String elfResult = elf.getCharacterInfo();


        if (orkResult.equals("Вадер - Орк. Вес: 145кг.\nОружие: Меч - Урон 10 единиц.")
            && elfResult.equals("Эйчи - Эльф. Вес: 63кг.\nОружие: Лук - Урон 9 единиц.")) {

            System.out.println("Пройден тест");
            System.out.println(orkResult);
            System.out.println(elfResult);

        } else {
            System.out.println("Неудача");
        }
    }
}