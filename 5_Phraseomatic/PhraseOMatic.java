public class PhraseOMatic {
    public static void main (String[] args)
    {
        String[] worldListOne = {"круглосуточный", "трех-звенный", "30000-метровый",
            "взаимный", "обоюдный выигрыш", "фронтэнд", "на основе веб-технологий",
            "проникающий", "умный", "шесть сигм", "метод критического пути", "динамичный",
            "основопологающий", "свежепахнущий", "крутецкий"                  
        };

        String[] worldListTwo = {"уполномоченный", "трудный", "чистый продукт", 
            "с дырочками", "ориентированный", "центральный", "деньгидобывающий", 
            "распределенный", "кластеризованный", "фирменный", "нелиняющий", 
            "нестандартный ум", "позицианированный", "сетевой", "бархатный",
            "сфокусированный", "использованный с выгодой", "выровненный", 
            "нацеленный на", "общий", "дикий", "свой", "ускоренный", "совместный"       
        };

        String[] worldListThree = {"процесс", "пункт прыбыли", "пункт разгрузки", "порт", 
            "выход из положения", "талант", "тип структуры", "юмор", "проход", "подход", 
            "уровень завоеванного внимания", "энтузиазм", "фарт", "портал", "период времени",
            "обзор", "образец", "пункт следования", "подарок"        
        };

        //вычисляем сколько слов в каждом массиве
        int oneLength = worldListOne.length;
        int twoLength = worldListTwo.length;
        int threeLength = worldListThree.length;

        //генерируем случайные числа
        int randOne = (int) (Math.random() * oneLength);
        int randTwo = (int) (Math.random() * twoLength);
        int randThree = (int) (Math.random() * threeLength);

        String phrase = worldListOne[randOne] + " " + worldListTwo[randTwo] + " " + 
            worldListThree[randThree];
        
        System.out.println("Всё, что нам нужно, это - " + phrase);
        //Всё, что нам нужно, это - свежепахнущий ориентированный юмор
    }
}
