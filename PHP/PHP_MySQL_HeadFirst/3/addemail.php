<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Добавить почту в БД</title>
    <link rel="stylesheet" href="">
</head>
<body>
<?php 
$mysqli = new mysqli ('localhost', 'serba', '08520852', 'elvis_store');

if ($mysqli->connect_error) die ('Ошибка (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error) . '<hr>';

$first_name = $_POST['firstname'];
$last_name = $_POST['lastname'];
$email = $_POST['email'];

$query = "INSERT INTO email_list VALUES (null, '$first_name', '$last_name', '$email')";

if (!$result = $mysqli->query($query)) die ('Ошибка выполнения запроса');

echo 'Запись добавленна. Спасибо!<br>';

$mysqli->close();
?>
<a href="/">На главную</a>
</body>
</html>