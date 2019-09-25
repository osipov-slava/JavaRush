package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader readerFile = new BufferedReader(new FileReader(args[0]));
        SortedMap<String, Double> records = new TreeMap<String, Double>();
        while (readerFile.ready()) {
            String[] str = readerFile.readLine().split(" ");
            Double salary = Double.parseDouble(str[1]);
            if (records.containsKey(str[0])) {
                records.put(str[0], salary + records.get(str[0]));
            } else records.put(str[0], salary);
        }
        readerFile.close();

        for (Map.Entry<String, Double> pair : records.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
