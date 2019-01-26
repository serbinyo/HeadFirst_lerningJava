<?php 
## Перебор списка.
  $dossier = [
    ["name" => "Thomas Anderson", "born" => "1962-03-11"],
    ["name" => "Keanu Reeves",    "born" => "1962-09-02"],
  ];
  for($i = 0; $i < count($dossier); $i++)
    echo "{$dossier[$i]['name']} was born {$dossier[$i]['born']}<br />";

## Перебор ассоциативного массива.
  $birth = [
    "Thomas Anderson" => "1962-03-11",
    "Keanu Reeves"    => "1962-09-02",
  ];
  //Косвенный перебор
  for (reset($birth); ($k = key($birth)); next($birth))
    echo "$k родился $birth[$k]<br>";
  //Косвенный перебор с конца
  for (end($birth); ($k = key($birth)); prev($birth))
    echo "$k родился $birth[$k]<br>";
  //Прямой перебор (рекомендованно к использованию)
  foreach ($birth as $k => $v) echo "$k родился $v<br>";
  //Прямой перебор списка
  foreach ($dossier as $v) echo $v['name'] ."<br>";
  /*
  Конструкция foreach работает с копией массива поэтому не позваляет изменять 
  значения перебираемыx элементов. В PHP существует разновидность цикла foreach, 
  позволяющая изменять итерируемый массив используя жосткую ссылку, через 
  ссылочный оператор & указанный перед именем переменной-элемента
  */
  foreach ($birth as $k => &$v) {
  	$v = $v . ' н.э';
  }
  unset($v);  // если не обнулить переменную содержащуб ссылку слудующий 
  			  //перебор перезапишет первое значение
  foreach ($birth as $k => $v) echo "$k родился $v<br>";

