package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> mapPair = new LinkedHashMap<>();
        Map<String, Integer> mapOnce = new LinkedHashMap<>();
        mapPair.put("IV", 4);
        mapPair.put("IX", 9);
        mapPair.put("XL", 40);
        mapPair.put("XC", 90);
        mapPair.put("CD", 400);
        mapPair.put("CM", 900);

        mapOnce.put("I", 1);
        mapOnce.put("V", 5);
        mapOnce.put("X", 10);
        mapOnce.put("L", 50);
        mapOnce.put("C", 100);
        mapOnce.put("D", 500);
        mapOnce.put("M", 1000);

        int sum = 0;

        for (Map.Entry<String, Integer> pair: mapPair.entrySet()) {
            if (s.contains(pair.getKey())) {
                s = s.replaceFirst(pair.getKey(),"");
                sum += pair.getValue();
            }
        }

        for (Map.Entry<String, Integer> pair: mapOnce.entrySet()) {
            for (int i = 0; i < 3; i++) {
                if (s.contains(pair.getKey())) {
                    s = s.replaceFirst(pair.getKey(),"");
                    sum += pair.getValue();
                }
            }
        }

        return sum;
    }
}
