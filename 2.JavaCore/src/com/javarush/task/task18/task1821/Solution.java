package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream inputStream = new FileInputStream(args[0]);
        int[] ch = new int[255];
        while (inputStream.available() > 0) {
            int symbol = inputStream.read();
            ch[symbol]++;
        }
        inputStream.close();

        for (int i = 0; i < ch.length ; i++) {
            if (ch[i]>0) System.out.println((char)i + " " + ch[i]);
        }

    }

}
