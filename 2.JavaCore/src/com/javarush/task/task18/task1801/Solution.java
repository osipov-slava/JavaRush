package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        int current;
        int max = 0;
        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read(); //читаем один байт из потока для чтения
            if (current > max) max = current;
        }
        System.out.println(max);
        fileInputStream.close();
        reader.close();
    }
}
