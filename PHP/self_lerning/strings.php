<?php

require_once'vendor/autoload.php';
require_once'dumper.php';

$string = "мама мыла раму";
$what = "раму";
$on_what = "папе спину";

$new_string = str_replace($what, $on_what, $string);

echo $string . "<br>\n";
echo $new_string . "<br>\n";

$subs = mb_substr($new_string, 0, -6);

echo $subs . "<br>\n";

$word = " шею";

$new_subs = substr_replace($subs, $word, (strlen($subs)));

echo $new_subs . "<br>\n";

$rep_string = strtr($new_subs, ['шею'=>'мама', 'мама'=>'шею']);

echo $rep_string . "<br>\n";

$strrep_string = str_replace(['шею','мама'], ['мама_зам','шею'], $rep_string);

echo $strrep_string . "<br>\n";

$correct_strrep_string = str_replace('шею_зам', 'мама', $strrep_string);

echo $correct_strrep_string . "<br>\n";

echo '<hr>';

$str = 'Нечто, очень похожее на земной автомобиль промелькнуло рядом';

$needle = ' на';

echo mb_strpos($str, $needle) . "<br>\n";

echo mb_substr($str, 0, mb_strpos($str, $needle)) . "<br>\n";

echo mb_substr($str, mb_strpos($str, $needle)) . "<br>\n";

echo mb_strstr($str, $needle) . "<br>\n";

echo mb_strstr($str, $needle, true) . "<br>\n";

echo str_replace('автомобиль', 'самолет', $str) . "<br>\n";


$str = 'Джунгли зовут!';

//$str_array = explode('', $str); //не работает

for ($i = 0; $i < mb_strlen($str); $i++) {
    $a[] = mb_substr($str, $i, 1); 
}

//eval(\Psy\sh());

dumper($a);

$str = 'Марс, Барс, Корс, Морс, Торс';
foreach (explode(', ', $str) as $value) {
    echo $value . "<br>"; 
}

$arr = ['key1' => 'Марс', 'key2' => 'Барс', 'key3' => 'Корс', 'key4' => 'Морс', 'key5' => 'Торс'];

echo implode(', ', $arr);
