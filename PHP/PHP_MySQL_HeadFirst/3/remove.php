<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Удалить почту в БД</title>
    <link rel="stylesheet" href="">
</head>
<body>
<?php 
    $mysqli = new mysqli ('localhost', 'serba', '08520852', 'elvis_store');

    if ($mysqli->connect_error) die ('Ошибка (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error) . '<hr>';

    if (isset($_POST['got_some_to_delete'])) {

        $to_delete = $_POST['to_delete'];
        foreach ($to_delete as $id) {
            $query = "DELETE FROM email_list WHERE id = '$id'";
            if (!$result = $mysqli->query($query)) die ('Ошибка удаления');
        }
    }

    $query = 'SELECT * FROM email_list';

    if (!$result = $mysqli->query($query)) die ('Ошибка выполнения запроса');
    if ($result->num_rows === 0) die ('В базе данных пока нет ни одной записи<br><a href="/">Назад</a>');
?>

<form action="<?= $_SERVER['REQUEST_URI'] ?>" method="post" accept-charset="utf-8">

    <?php

    while ($row = $result->fetch_array())
        echo "<input type='checkbox' name='to_delete[]' value='". $row['id'] ."'>"
            . ' ' . $row['first_name']
            . ' ' . $row['last_name']
            . ' ' . $row['email'] . '<br>';

    $mysqli->close();

    ?>

    <input type="submit" name="got_some_to_delete" value="Удалить">
</form>

<a href="/">На главную</a>
</body>
</html>