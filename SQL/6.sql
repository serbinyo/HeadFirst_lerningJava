/*
Упражнение на сортировку различных символов. 
Head First.
Изучаем SQL. Линн Бейли.
Стр 287
*/

CREATE DATABASE sort_test;

USE sort_test;

CREATE TABLE sort_list
(
	test_chars CHAR(1)
);

DESC sort_list;

INSERT INTO sort_list
VALUES 
(0),
(1),
(2),
(3),
('A'),
('B'),
('C'),
('a'),
('b'),
('c'),
(''),
('Б'),
('В'),
('Г'),
('б'),
('в'),
('г'),
('!'),
('@'),
('#'),
('$'),
('%'),
('%'),
('^'),
('&'),
('*'),
('('),
(')'),
('-'),
('_'),
('+'),
('='),
('['),
(']'),
('{'),
('}'),
(';'),
(':'),
('\''),
('>'),
('<'),
('\\'),
('|'),
('`'),
('~'),
('/'),
('?');

SELECT test_chars FROM sort_list
ORDER BY test_chars;

DELETE FROM sort_list;

INSERT INTO sort_list
VALUES 
('+'),
('='),
('!'),
('('),
('&'),
('~'),
('"'),
('*'),
('@'),
('?'),
('\'');

SELECT test_chars FROM sort_list
ORDER BY test_chars;
