package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);

        int current;
        HashMap<Integer,Integer> maxValues = new HashMap <Integer, Integer>();
        int max = 0;
        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read(); //читаем один байт из потока для чтения
            if (!maxValues.containsKey(current)) maxValues.put(current,1);
            else maxValues.put(current, maxValues.get(current).intValue() + 1);
            if (maxValues.get(current) > max) max = maxValues.get(current); // обновление максимума
        }

        for (Map.Entry<Integer, Integer> pair : maxValues.entrySet()) {
            if (pair.getValue()== max) System.out.print("" + pair.getKey() + " ");
        }

        fileInputStream.close();
        reader.close();
    }
}
