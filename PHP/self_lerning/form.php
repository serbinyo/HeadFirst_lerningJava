<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Форма</title>
    <link rel="stylesheet" href="">
</head>
<body>
    <a href="<?=$_SERVER[FILE_NAME]?>">Рестарт</a>
    <?php if (!isset($_REQUEST['doGO'])) { ?>

        <form action="form.php">
            Логин: <input type="text" name="login" placeholder="логин"> <br>
            Пароль: <input type="text" name="password" placeholder="пароль"> <br>
            <input type="submit" name="doGO" value="Нажмите кнопку">
        </form>

    <?php }  else {

            if ($_REQUEST['login'] === 'root' && $_REQUEST['password'] === 'PaSS11word') {
                echo "<h2>Доступ получен</h2>";
                system("rundll32.exe user32.dll, LockWorkStation");

            } else {
                echo "<h2>Доступ закрыт</h2>";
            }

        } 
    ?>
</body>
</html>