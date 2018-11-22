CREATE DATABASE construction;

USE construction;

CREATE TABLE projects
(
	number INT,
	descriptionofproj VARCHAR(50),
	contractoronjob VARCHAR(10)
);

DESCRIBE projects;

ALTER TABLE projects
RENAME project_list;

DESCRIBE project_list;

INSERT INTO project_list
(number, descriptionofproj, contractoronjob)
VALUES
(1, 'покраска дома', 'Мэрфи'),
(2, 'перестройка кухни', 'Вальдес'),
(3, 'укладка паркета', 'Келлер'),
(4, 'кровельные работы', 'Джексон');

SELECT * FROM project_list;

--ИЗМЕНЕНИЕ СТРУКТУРЫ ТАБЛИЦы

ALTER TABLE project_list
CHANGE number proj_id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (proj_id);

ALTER TABLE project_list
CHANGE COLUMN descriptionofproj proj_desc VARCHAR(100),
CHANGE COLUMN contractoronjob con_name VARCHAR(30);

ALTER TABLE project_list
MODIFY COLUMN proj_desc VARCHAR(100) AFTER con_name;

ALTER TABLE project_list
ADD con_phone VARCHAR(10),
ADD est_cost DECIMAL(7,2),
ADD start_date DATE;

ALTER TABLE project_list
ADD COLUMN con_address VARCHAR(10) NOT NULL;

ALTER TABLE project_list
DROP COLUMN con_address;

ALTER TABLE project_list
DROP start_date;