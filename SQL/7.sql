CREATE DATABASE girlscouts;

USE girlscouts;

CREATE TABLE cookie_sales
(
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(id),
	first_name VARCHAR(10) NOT NULL,
	sales DEC(5,2) NOT NULL,
	sale_date DATE NOT NULL
);

DESC cookie_sales;

INSERT INTO cookie_sales
(id, first_name, sales, sale_date)
VALUES 
(NULL, 'Линдси', 32.02, '2007-03-06'),
(NULL, 'Пэрис', 26.53, '2007-03-06'),
(NULL, 'Бритни', 11.25, '2007-03-06'),
(NULL, 'Николь', 18.96, '2007-03-06'),
(NULL, 'Линдси', 9.16, '2007-03-07'),
(NULL, 'Пэрис', 1.52, '2007-03-07'),
(NULL, 'Бритни', 43.21, '2007-03-07'),
(NULL, 'Николь', 8.05, '2007-03-07'),
(NULL, 'Линдси', 17.62, '2007-03-08'),
(NULL, 'Пэрис', 24.19, '2007-03-08'),
(NULL, 'Бритни', 3.40, '2007-03-08'),
(NULL, 'Николь', 15.21, '2007-03-08'),
(NULL, 'Линдси', 0, '2007-03-09'),
(NULL, 'Пэрис', 31.99, '2007-03-09'),
(NULL, 'Бритни', 2.58, '2007-03-09'),
(NULL, 'Николь', 0, '2007-03-09'),
(NULL, 'Линдси', 2.34, '2007-03-10'),
(NULL, 'Пэрис', 13.44, '2007-03-10'),
(NULL, 'Бритни', 8.78, '2007-03-10'),
(NULL, 'Николь', 26.82, '2007-03-10'),
(NULL, 'Линдси', 3.71, '2007-03-11'),
(NULL, 'Пэрис', 0.56, '2007-03-11'),
(NULL, 'Бритни', 34.19, '2007-03-11'),
(NULL, 'Николь', 7.77, '2007-03-11'),
(NULL, 'Линдси', 16.23, '2007-03-12'),
(NULL, 'Пэрис', 0, '2007-03-12'),
(NULL, 'Бритни', 4.50, '2007-03-12'),
(NULL, 'Николь', 19.22, '2007-03-12');

SELECT * FROM cookie_sales;

SELECT first_name, sales FROM cookie_sales
ORDER BY first_name;

--Использование агрегатных функций

--кто заработал больше всех на продажде печенья?
SELECT SUM(sales)
FROM cookie_sales
WHERE first_name = 'Николь';

/*
Оператор SQL HAVING является указателем на результат выполнения агрегатных функций.
Если в выражении запроса не указано предложение GROUP BY, 
то предполагается неявным образом созданная группа, состоящая из одного набора.
HAVING без GROUPE BY работает так же как и WHERE. Лучше успользовать WHERE.
*/
SELECT SUM(sales)
FROM cookie_sales
WHERE first_name = 'Николь'
HAVING SUM(sales) > 90;

SELECT SUM(sales)
FROM cookie_sales
GROUP BY first_name;

SELECT first_name, SUM(sales) AS all_sum
FROM cookie_sales
GROUP BY first_name
ORDER BY all_sum DESC;

SELECT first_name, SUM(sales) AS all_sum
FROM cookie_sales
WHERE sale_date = '2007-03-10'
GROUP BY first_name
ORDER BY all_sum DESC;

SELECT first_name, SUM(sales) AS all_sum
FROM cookie_sales
GROUP BY first_name
HAVING all_sum > 90
ORDER BY all_sum DESC;

SELECT first_name, SUM(sales) AS all_sum
FROM cookie_sales
GROUP BY first_name
ORDER BY all_sum DESC
LIMIT 1;

--сколько в среднем за день получился заработок девлчек?

SELECT first_name, AVG(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY AVG(sales) DESC;

--максимум и минимум по девочкам

SELECT first_name, MIN(sales) AS min_sale
FROM cookie_sales
GROUP BY first_name
ORDER BY min_sale DESC;

SELECT first_name, MAX(sales) 
FROM cookie_sales
GROUP BY first_name
ORDER BY MAX(sales) DESC;

--подсчет дней сколько каждая девочка продовала печенье

SELECT first_name, count(sales)
FROM cookie_sales
GROUP BY first_name;

--DISTINCT значения без дубликатов

SELECT DISTINCT sale_date
FROM cookie_sales;

SELECT COUNT(DISTINCT sale_date)
FROM cookie_sales;