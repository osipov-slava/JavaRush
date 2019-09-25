package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> stringStringHashMap= new HashMap<String, String>();

        stringStringHashMap.put("арбуз", "ягода");
        stringStringHashMap.put("банан","трава");
        stringStringHashMap.put("вишня","ягода");
        stringStringHashMap.put("груша","фрукт");
        stringStringHashMap.put("дыня","овощ");
        stringStringHashMap.put("ежевика","куст");
        stringStringHashMap.put("жень-шень","корень");
        stringStringHashMap.put("земляника","ягода");
        stringStringHashMap.put("ирис","цветок");
        stringStringHashMap.put("картофель","клубень");

        for (Map.Entry<String, String> pair : stringStringHashMap.entrySet()) {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + " - " + value);
        }
    }
}
