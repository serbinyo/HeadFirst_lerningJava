<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Aliens Abducted Me - Report an Abduction</title>
</head>
<body>
    <h2>Aliens Abducted Me - Report an Abduction and store to database</h2>

<?php
    $name = $_POST['firstname'] . ' ' . $_POST['lastname'];
    $first_name = $_POST['firstname'];
    $last_name = $_POST['lastname'];
    $when_it_happened = $_POST['whenithappened'];
    $how_long = $_POST['howlong'];
    $how_many = $_POST['howmany'];
    $alien_description = $_POST['aliendescription'];
    $what_they_did = $_POST['whattheydid'];
    $fang_spotted = $_POST['fangspotted'];
    $email = $_POST['email'];
    $other = $_POST['other'];

    $mysqli = new mysqli
        (
            'localhost',
            'serba',
            '08520852',
            'aliendatabase'
        );

    if ($mysqli->connect_error) 
        die 
            ('(' 
            . $mysqli->connect_errno
            . ')'
            . $mysqli->connect_error
            . '<hr>'
            );

    $query = "INSERT INTO aliens_abduction "
        . "(first_name , last_name, when_it_happened, how_long, how_many" 
        . ", alien_description, what_they_did, fang_spotted, other, email) " 
        . "VALUES ('$first_name' , '$last_name', '$when_it_happened', '$how_long'" 
        . ", '$how_many', '$alien_description', '$what_they_did', '$fang_spotted'"
        . ", '$other', '$email')";

    if ($result = $mysqli->query($query))
        echo 'Спасибо запись добавленна в базу данных.<br>';

    $result->close;
    $mysqli->close;

    echo "<hr> $query <hr>";
  
    echo 'Thanks for submitting the form ' . $name . '<br />';
    echo 'You were abducted ' . $when_it_happened;
    echo ' and were gone for ' . $how_long . '<br />';
    echo 'Number of aliens: ' . $how_many . '<br />';
    echo 'Describe them: ' . $alien_description . '<br />';
    echo 'The aliens did this: ' . $what_they_did . '<br />';
    echo 'Was Fang there? ' . $fang_spotted . '<br />';
    echo 'Other comments: ' . $other . '<br />';
    echo 'Your email address is ' . $email . '<br />';
?>

<a href="/">На главную</a>

</body>
</html>
