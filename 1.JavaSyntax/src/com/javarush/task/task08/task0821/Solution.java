package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map= new HashMap<String, String>();
        map.put("kjbkah","jbdkjb");
        map.put("nnn","sdgsd");
        map.put("nnn","sgdg");
        map.put("nnn","sgdg");
        map.put("dxfhzg","sgdg");
        map.put("sdfSD","sgSDfdg");
        map.put("rdsy","sgSDsfvzfdg");
        map.put("stry","jilj");
        map.put("qwr","cvn");
        map.put("io","xcv");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
