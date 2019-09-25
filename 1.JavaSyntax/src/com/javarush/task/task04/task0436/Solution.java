package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a1 = Integer.parseInt(s1); //преобразовываем строку в число.
        int a2 = Integer.parseInt(s2); //преобразовываем строку в число.

        for (int i=0; i!=a1; i++){
            for (int j=0; j!=a2; j++) System.out.print("8");
            System.out.println("");
        }
//напишите тут ваш код

    }
}
