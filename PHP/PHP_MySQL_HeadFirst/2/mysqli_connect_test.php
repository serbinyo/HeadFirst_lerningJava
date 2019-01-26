<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>mysqli_connect_test</title>
	<link rel="stylesheet" href="">
</head>
<body>

<h2>mysqli test:</h2><br>

<?php 

require_once '../dumper.php';

$mysqli = new mysqli('localhost', 'serba', '08520852', 'aliendatabase');

if ($mysqli->connect_error) 
	die (
		'Ошибка (' 
		. $mysqli->connect_errno . ') '
    	. $mysqli->connect_error
    );

echo $mysqli->host_info . '<br>';

if ($result = $mysqli->query('SELECT * FROM aliens_abduction'))
	echo 'Запрос вернул ' . $result->num_rows . ' строк <br>';
else
	echo 'Запрос ничего не вернул <br>';

while ($row = $result->fetch_array(MYSQLI_ASSOC))
    echo $row['first_name'] . '<br>';

// foreach ($result->fetch_all()  as $row)
//     dumper($row);


$result->close();
$mysqli->close();
?>

</body>
</html>