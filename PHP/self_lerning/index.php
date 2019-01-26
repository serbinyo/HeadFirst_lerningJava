<?php ##Проверочный скрипт PHP
// echo "Hello Serba!";

// $arr = ['вилка'=>'32.50','тарелка'=>'178.10'];

// $r =& $arr['ложка'];

// echo "<br>Ваша переменная равна = " . $arr['ложка'];
// echo "<br>Теп неинициализированной переменной: " . gettype($r) . "<br>";

class SomeClass
{
	private $x = 100;
}

$obj = new SomeClass();

echo "<pre>";
var_export($obj);
echo "</pre>";


$st = `serba.com/c dir`;
echo "<pre>$st</pre>";