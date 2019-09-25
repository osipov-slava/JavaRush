package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerFile = new BufferedReader(new FileReader(args[0]));
        SortedMap<String, Double> records = new TreeMap<String, Double>();
        Double maxSum = 0.0;
        while (readerFile.ready()) {
            String[] str = readerFile.readLine().split(" ");
            Double salary = Double.parseDouble(str[1]);

            if (records.containsKey(str[0])) {
                salary += records.get(str[0]);
                records.put(str[0], salary);
            } else {
                records.put(str[0], salary);
            }
            if (maxSum < salary) maxSum = salary;
        }
        readerFile.close();

        for (Map.Entry<String, Double> pair : records.entrySet()) {
            if (pair.getValue().equals(maxSum)) System.out.println(pair.getKey());
        }
    }
}
