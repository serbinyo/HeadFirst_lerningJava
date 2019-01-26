<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Удалить почту из БД</title>
    <link rel="stylesheet" href="">
</head>
<body>
<?php 
$mysqli = new mysqli ('localhost', 'serba', '08520852', 'elvis_store');

if ($mysqli->connect_error) die ('Ошибка (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error) . '<hr>';

$email = $_POST['email'];

$query = "DELETE FROM email_list WHERE email = '$email'";

if (!$result = $mysqli->query($query)) die ('Ошибка выполнения запроса');

echo 'Ок. Спасибо!<br>';

$mysqli->close();
?>
<a href="/">На главную</a>
</body>
</html>