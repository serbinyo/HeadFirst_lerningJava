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
