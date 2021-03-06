CREATE DATABASE gregs_list;
USE gregs_list;

CREATE TABLE my_contacts 
( 
	first_name VARCHAR(20), 
	last_name VARCHAR(20), 
	gender CHAR(1), 
	birthday DATE, 
	email VARCHAR(50), 
	profession VARCHAR(50), 
	location VARCHAR(50), 
	status VARCHAR(20), 
	interests VARCHAR(100), 
	seeking VARCHAR(100) 
);

INSERT INTO my_contacts
(
first_name, last_name, email, gender, birthday,
profession, location, status, interests, seeking
)
VALUES
( 
'Джиллиан', "Андерсон", "jill_anderson@breckneckpizza.com", "ж", "1980-05-09", 
"Писатель", "Пало-Альто, СА", "Не замужем", "Каяк, террариум", "Друзья" 
);

INSERT INTO my_contacts
(
first_name, last_name, email, gender, birthday,
profession, location, status, interests, seeking
)
VALUES
( 
'Кент', "Брокман", "kent_tv_maker@breckneckpizza.com", "м", "1972-05-19", 
"Телеведущий", "Пало-Альто, СА", "Не женат", "Скачки, сигары", "Друзья" 
);

INSERT INTO doughnuts_list
(
donut_type, dozens, topping, price
)
VALUES
(
"с вареньем", 3, "sprinkles", 3.50
);

SELECT * FROM my_contacts;

CREATE TABLE names 
( 
	id INT NOT NULL AUTO_INCREMENT, 
	first_name VARCHAR(10), 
	last_name VARCHAR(10), 
	PRIMARY KEY (id)
);

SHOW CREATE TABLE names;

INSERT INTO names
(id, first_name, last_name)
VALUES
(NULL, 'Мария', 'Варди');

INSERT INTO names
(id, first_name, last_name)
VALUES
(1, 'Джен', 'Брэди');

INSERT INTO names
VALUES
('', 'Бобби', 'Фулер');

INSERT INTO names
(first_name, last_name)
VALUES
('Синди', 'Кук');

INSERT INTO names
(id, first_name, last_name)
VALUES
(99, 'Питер', 'Паркер');

SELECT * FROM names;


--ИЗМЕНЕНИЕ СТРУКТУРЫ ТАБЛИЦы

ALTER TABLE my_contacts
ADD COLUMN contact_id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (contact_id); 

SELECT * FROM my_contacts;

ALTER TABLE my_contacts
DROP COLUMN contact_id;

ALTER TABLE my_contacts
ADD COLUMN contact_id INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (contact_id);

SELECT * FROM my_contacts;

ALTER TABLE my_contacts
ADD COLUMN tel_number VARCHAR(10);

--СТРОКОВЫЕ ФУНКЦИИ

ALTER TABLE my_contacts
ADD city VARCHAR(48) AFTER location,
ADD state CHAR(2) AFTER city;

UPDATE my_contacts
SET state = RIGHT(location, 2),
city = SUBSTRING_INDEX(location, ',', 1);

ALTER TABLE my_contacts DROP COLUMN location;

SELECT SUBSTRING('Сан-Антонио, TX', 5, 3);
SELECT UPPER('моРОжЕнНоЕ');
SELECT LOWER('моРОжЕнНоЕ');
SELECT REVERSE('abcde');
SELECT LTRIM(' собака ');
SELECT RTRIM(' кошка ');
SELECT LENGTH('abcde');


--Создание таблицы с набором данных при помощи ключевого слова AS
CREATE TABLE profession 
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	profession VARCHAR(50) NOT NULL
) AS
SELECT profession 
FROM my_contacts;  

SELECT * FROM profession;