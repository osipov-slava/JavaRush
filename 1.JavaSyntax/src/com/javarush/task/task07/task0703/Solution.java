package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String [] str=new String[10];//напишите тут ваш код;
        int [] a=new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<str.length;i++)
            str[i]=reader.readLine();
        for (int i=0;i<a.length;i++)
            System.out.println(str[i].length());
    }
}
