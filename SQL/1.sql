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
'Djillian', "Андерсон", "jill_anderson@breckneckpizza.com", "ж", "1980-05-09", 
"Писатель", "Пало-Альто, СА", "Не замужем", "Каяк, террариум", "Друзья" 
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