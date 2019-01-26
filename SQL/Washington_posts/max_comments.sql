SELECT p.name, COUNT(c.id) as comments
FROM post p
JOIN comment c
ON p.id = c.post_id
GROUP BY p.id
ORDER BY comments DESC
LIMIT 1;

SELECT p.name, COUNT(c.id) as comments
FROM post p
JOIN comment c
ON p.id = c.post_id
GROUP BY p.id
HAVING comments = 
(SELECT COUNT(*) as result
FROM comment
GROUP BY post_id
ORDER BY result DESC
LIMIT 1);

