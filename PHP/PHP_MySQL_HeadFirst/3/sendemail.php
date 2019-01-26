<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Послать рассылку</title>
    <link rel="stylesheet" href="">
</head>
<body>
<?php 
$mysqli = new mysqli ('localhost', 'serba', '08520852', 'elvis_store');

if ($mysqli->connect_error) die ('Ошибка (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error) . '<hr>';

$from = 'admin@elvis_shop.com';
$subject = $_POST['subject'];
$elvismail = $_POST['elvismail'];

if (empty($subject) || empty($elvismail)) 
    die ('Есть незаполненные поля<br><a href="/3/sendemail.html">Назад</a>');

$query = "SELECT * FROM email_list";

if (!$result = $mysqli->query($query)) die ('Ошибка выполнения запроса');

while ($row = $result->fetch_array(MYSQLI_ASSOC)) {
    $first_name = $row['first_name'];
    $last_name = $row['last_name'];
    $to = $row['email'];

    $msg = "Уважаемый $first_name $last_name,\n$elvismail";

    mail($to, $subject, $msg, 'From:' . $from);

    echo "Электронное письмо отправленно: $to<br>";
}

echo "<br>Рассылка ушла. Спасибо!<br>";

$result->close();
$mysqli->close();
?>
<a href="/">На главную</a>
</body>
</html>