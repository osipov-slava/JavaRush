package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int i=0;
        while (true) {
            String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
            int a = Integer.parseInt(s1); //преобразовываем строку в число.
            i=i+a;
            if (a==-1) break;
}
        System.out.println(i);//напишите тут ваш код
    }
}
