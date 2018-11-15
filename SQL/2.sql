CREATE DATABASE drinks;
USE drinks;

CREATE TABLE easy_drinks
(
drink_name VARCHAR(50) NOT NULL,
main VARCHAR(100) NOT NULL,
amount1 DEC(3,2) NOT NULL,
second VARCHAR(100) NOT NULL,
amount2 DEC(3,2) NOT NULL,
directions VARCHAR(255) NOT NULL
);

DESC easy_drinks;

INSERT INTO easy_drinks
( drink_name, main, amount1, 
second, amount2, directions )
VALUES
('Терновник', 'тоник', 1.5, 'ананасовый сок', 1, 'взболтать со льдом, разлить по бокалам, украсить лимонной цедрой'),
('Голубая луна', 'содовая', 1.5, 'черничный сок', 0.75, 'взболтать со льдом, разлить по бокалам, украсить лимонной цедрой'),
('Вот тебе на', 'персиковый нектар', 1, 'ананасовый сок', 1, 'взболтать со льдом, разлить по бокалам'),
('Лаймовый физз', 'Спрайт', 1.5, 'сок лайма', 0.75, 'взболтать со льдом, разлить по бокалам'),
('Поцелуй', 'вишневый сок', 2, 'абрикосовый нектар', 7, 'подавать со льдом и соломинкой'),
('Горячее золото', 'персиковый нектар', 3, 'апельсиновый сок', 6, 'влить в кружку горячий апельсиновый сок, добавить персиковый нектар'),
('Одинокое дерево', 'содовая', 1.5, 'вишневый сок', 0.75, 'взболтать со льдом, разлить по бокалам'),
('Борзая', 'содовая', 1.5, 'грейпфрутовый сок', 5, 'подавать со льдом, тщательно взболтать'),
('Бабье лето', 'яблочный сок', 2, 'горячий чай', 6, 'налить сок в кружку, добавить горячий чай'),
('Лягушка', 'холодный чай', 1.5, 'лимонад', 5, 'подавать на льду с ломтиком лайма'),
('Сода плюс', 'содовая', 2, 'виноградный сок', 1, 'взболтать в бокале, подавать без льда');

SELECT * FROM easy_drinks;

SELECT * FROM easy_drinks WHERE main = 'содовая';

SELECT drink_name FROM easy_drinks WHERE main = 'содовая' AND amount1 = 2 AND amount1 = 1.5;

CREATE TABLE drink_info
(
drink_name VARCHAR(50) NOT NULL,
cost DECIMAL(3.1) NOT NULL,
carbs DECIMAL(4.1) NOT NULL,
color VARCHAR(20) NOT NULL,
ice CHAR(1) NOT NULL,
calories int NOT NULL
);

INSERT INTO drink_info
(
	drink_name, cost, carbs, color, ice, calories
)
VALUES
('Терновник', 3, 8.4, 'желтый', 'Д', 33),
('Голубая луна', 2.5, 3.2, 'синий', 'Д', 12),
('Вот тебе на', 3.5, 8.6, 'оранжевый', 'Д', 35),
('Лаймовый физз', 2.5, 5.4, 'зеленый', 'Д', 24),
('Поцелуй', 5.5, 42.5, 'фиолетовый', 'Д', 171),
('Горячее золото', 3.2, 32.1, 'оранжевый', 'Н', 135),
('Одинокое дерево', 3.6, 4.2, 'красный', 'Д', 17),
('Борзая', 4, 14, 'желтый', 'Д', 50),
('Бабье лето', 2.8, 7.2, 'коричневый', 'Н', 30),
('Лягушка', 2.6, 21.5, 'бронзовый', 'Д', 80),
('Сода плюс', 3.8, 4.7, 'красный', 'Н', 19);

SELECT * FROM drink_info;

SELECT drink_name, cost
FROM drink_info
WHERE
color = 'желтый'
AND
ice = 'Д'
AND
calories > 33;

SELECT drink_name, color
FROM drink_info
WHERE
carbs <= 4
AND
ice = 'Д';

SELECT drink_name, cost
FROM drink_info
WHERE
calories >= 80;

SELECT drink_name, color, ice
FROM drink_info
WHERE
cost <= 5.5
AND
cost >= 4;

UPDATE drink_info
SET color = 'золотистый'
WHERE color = 'желтый';