<?php

require_once('vendor/autoload.php');

use Monolog\Logger;
use Monolog\Handler\StreamHandler; 

$log = new Logger('my_log');

$handler = new StreamHandler('logs/warnings/log', Logger::WARNING);

$log->pushHandler($handler);

function increment (&$a) {
	echo "До увеличения: " . $a . "<br>";
	$a++;
	echo "После увеличения: " . $a . "<br>";
    
}

$num = 100;

increment($num);

$log->warning($num, ['До увеличения:' => 'чуть меньше', 'После увеличения' => 'немного больше']);
$log->error($num, ['До увеличения:' => 'много меньше']);

echo '$num = ' . $num . "<br>";



//eval(\Psy\sh());