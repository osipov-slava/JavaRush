package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int b=0,c=0;
        for (int i=1; i<4;i++) {
            String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
            int a = Integer.parseInt(s1); //преобразовываем строку в число.
            if (a>0) b++;
            if (a<0) c++;
        }

        System.out.println("количество отрицательных чисел: "+c); //напишите тут ваш код
        System.out.println("количество положительных чисел: "+b); //напишите тут ваш код

    }
}
