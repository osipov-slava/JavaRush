package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String,String > map =new HashMap<String, String>();
        map.put("sdfsef","s");
        map.put("zsdgdsf","ssdf");
        map.put("sdga","sasd");
        map.put("sdfasg","sas");
        map.put("zsdvsdr","sawd");
        map.put("sdzsd","swda");
        map.put("zsdgz","ssda");
        map.put("zsdga","sas");
        map.put("zdsfve","s");
        map.put("zsgz","s");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {

        ArrayList<String> arrayList= new ArrayList<String>(map.values());
        for (int i=0; i<arrayList.size();i++){
            for (int j=0;j<arrayList.size();j++){
                if (arrayList.get(i)==arrayList.get(j) && i!=j) removeItemFromMapByValue(map,arrayList.get(i));
            }

        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
