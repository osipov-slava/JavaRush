package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int maximum = 0;

        do {
            String s1 = reader.readLine(); //читаем строку с клавиатуры
            n = Integer.parseInt(s1); //преобразовываем строку в число.
        } while (n<=0);
        String s2 = reader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(s2); //преобразовываем строку в число.
        maximum=a;

        for (int i=1;i<n;i++){
            String s1 = reader.readLine(); //читаем строку с клавиатуры
            a = Integer.parseInt(s1); //преобразовываем строку в число.
            if (a>maximum) maximum=a;
        }

        System.out.println(maximum);
    }
}
