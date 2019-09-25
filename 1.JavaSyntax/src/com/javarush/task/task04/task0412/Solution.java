package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(sAge); //преобразовываем строку в число.
        //напишите тут ваш код

        if (a<0) a++;
        if (a>0) a=a*2;
        System.out.println(a);
    }

}