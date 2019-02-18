<?php

function notToLongWords($phrase) 
{
    $phrase_arr = explode(' ', $phrase);
    for ($i=0; $i < count($phrase_arr); $i++) { 
        if (mb_strlen($phrase_arr[$i]) > 7)
            $phrase_arr[$i] = mb_substr($phrase_arr[$i], 0, 6) . '*';
    }
    return implode(' ', $phrase_arr);
}

echo notToLongWords('солнце тарарарар мир крандштадт');
