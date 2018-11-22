/*
Упражнение на модификацию таблцы. 
Head First.
Изучаем SQL. Линн Бейли
Стр 251
*/

CREATE DATABASE car;

USE car;

CREATE TABLE hoopie
(
	color VARCHAR(12),
	year INT,
	make VARCHAR(10),
	mo VARCHAR(10),
	howmuch DECIMAL(8,3) 
);

DESCRIBE hoopie;

ALTER TABLE hoopie
RENAME car_table,
CHANGE COLUMN mo model VARCHAR(10),
CHANGE COLUMN howmuch price DECIMAL(8,3),
MODIFY COLUMN color VARCHAR(12) AFTER model,
MODIFY COLUMN year INT AFTER color,
ADD COLUMN VIN VARCHAR(20) FIRST,
ADD COLUMN car_id INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (car_id);
