package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int b=0;
        for (int i=1; i<4;i++) {
            String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
            int a = Integer.parseInt(s1); //преобразовываем строку в число.
            if (a>0) b++;
        }
        System.out.println(b);
    }
}
