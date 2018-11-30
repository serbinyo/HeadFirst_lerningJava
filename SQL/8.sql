CREATE DATABASE piggy_bank;
USE piggy_bank;

CREATE TABLE piggy_bank
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	coin CHAR(1) NOT NULL,
	coin_year CHAR(4)
);

DESC piggy_bank;

INSERT INTO piggy_bank
(coin, coin_year)
VALUES
('Q','1950'),
('P','1972'),
('N','2005'),
('Q','1999'),
('Q','1981'),
('D','1940'),
('Q','1980'),
('P','2001'),
('D','1926'),
('P','1999');

SELECT * FROM piggy_bank;

CREATE VIEW pb_quaters AS
SELECT * FROM piggy_bank
WHERE coin = 'Q';

SELECT * FROM pb_quaters;

CREATE VIEW pb_dimes AS
SELECT * FROM piggy_bank
WHERE coin = 'D'
WITH CHECK OPTION;

SELECT * FROM pb_dimes;

INSERT INTO pb_quaters VALUES (null, 'Q', 1933);
INSERT INTO pb_quaters VALUES (null, 'D', 1942);

INSERT INTO pb_dimes VALUES (null, 'Q', 2005);

DELETE FROM pb_quaters 
WHERE coin = 'N' OR coin = 'D' OR coin = 'P';

UPDATE pb_quaters 
SET coin = 'Q' 
WHERE coin = 'P';
