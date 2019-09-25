package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(file);

        int current;
        SortedSet<Integer> valuesByte = new TreeSet<Integer>();

        while (fileInputStream.available() > 0)
        {
            valuesByte.add(fileInputStream.read()); //читаем один байт из потока для чтения
        }

        for (Integer a: valuesByte) {
            System.out.print(a + " ");
        }

        fileInputStream.close();
    }
}
