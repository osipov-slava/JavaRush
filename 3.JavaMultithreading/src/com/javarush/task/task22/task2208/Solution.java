package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("name",null);
        map.put("country",null);
        map.put("city", null);
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> pair: params.entrySet()) {
            if (pair.getValue() == null) continue;
            sb.append(pair.getKey());
            sb.append(" = '");
            sb.append(pair.getValue());
            sb.append("' and ");
        }
        if (sb.length() == 0) return "";
        sb.delete(sb.length()-5,sb.length());
        return sb.toString();
    }
}
