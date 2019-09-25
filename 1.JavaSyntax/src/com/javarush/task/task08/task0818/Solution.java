package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer > map =new HashMap<String, Integer>();
        map.put("sdfsef",424);
        map.put("sdgag",424);
        map.put("sdfsdfgssef",678);
        map.put("sdfasdfzsef",574);
        map.put("sdfsrwetef",424);
        map.put("sdfassef",-578);
        map.put("sdfxsef",0);
        map.put("sdfzsef",5674);
        map.put("sdfbsef",23);
        map.put("sdfrsef",424);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue()<500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {


    }
}