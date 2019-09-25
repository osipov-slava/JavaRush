package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String,String> hashMap= new HashMap<>();
        hashMap.put("Осипов","Вячеслав");
        hashMap.put("Сидоров","Андрей");
        hashMap.put("Бугаев","Александр");
        hashMap.put("Соловьев","Владимир");
        hashMap.put("Путин","Ярослав");
        hashMap.put("Кутепов","Андрей");
        hashMap.put("Геращенко","Александр");
        hashMap.put("Иванов","Андрей");
        hashMap.put("Петров","Алексей");
        hashMap.put("Валдин","Вячеслав");
        return hashMap;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        Iterator<HashMap.Entry<String,String>> iterator = map.entrySet().iterator();
        int count=0;
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            HashMap.Entry<String,String> pair = iterator.next();
            String value = pair.getValue();        //значение
            if (name.equals(value)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        Iterator<HashMap.Entry<String,String>> iterator = map.entrySet().iterator();
        int count=0;
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            HashMap.Entry<String,String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            if (key==lastName) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
