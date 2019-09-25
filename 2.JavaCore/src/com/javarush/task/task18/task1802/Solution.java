package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        int current;
        int min = 255;
        while (fileInputStream.available() > 0)
        {
            current = fileInputStream.read(); //читаем один байт из потока для чтения
            if (current < min) min = current;
        }
        System.out.println(min);
        fileInputStream.close();
        reader.close();
    }
}
