<?php

/*
* Написать код который будет принимать массив размерностью M на N
* и считать сумму элементов в строке с наименьшим колличеством
* четных элементов.
* 
* Алгоритм решения:
* 1. Посчитать сколько нечетных элементов в каждой
*    строке и записать их в новый массив.
*
* 2. По массиву нечетных элементов определить минимальный
*    и по нему определить индекс искомой строки.
* 
* 3. Посчитать сумму элементов в искомой строке и вывести результат
*/
require_once '../dumper.php';
require_once '../vendor/autoload.php';

$numCube = [
    [2, 1, 17, 51, 66, 20],
    [4, 4, 8, 7, 16, 18],
    [1, 3, 5, 17, 9, 10],          // 45
    [2, 4, 6, 8, 10, 11]
];

function sumOddRow($arr)
{
    for ($i=0; $i < count($arr); $i++) {
        $count = 0;
        for ($j=0; $j < count($arr[$i]); $j++) {
            if ($arr[$i][$j]%2 === 0) {
                $count++;
            }
        }
        $arr_of_odd[] = $count;
    }

    $min_element = min($arr_of_odd);
    $index_row = array_search($min_element, $arr_of_odd);

    $result = 0;
    for ($j=0; $j < count($arr[$index_row]); $j++) {
        $result += $arr[$index_row][$j];
    }

    return $result;
}

echo sumOddRow($numCube);
