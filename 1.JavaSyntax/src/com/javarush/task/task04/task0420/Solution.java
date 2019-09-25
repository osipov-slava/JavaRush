package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s3 = bufferedReader.readLine(); //читаем строку с клавиатуры

        int a = Integer.parseInt(s1); //преобразовываем строку в число.
        int b = Integer.parseInt(s2); //преобразовываем строку в число.
        int c = Integer.parseInt(s3); //преобразовываем строку в число.
        int i=0;


        if (a<b) {i=a;a=b;b=i;};
        if (b<c) {i=b;b=c;c=i;};
        if (a<b) {i=a;a=b;b=i;};



        System.out.println(""+a+" "+ b+" "+ c);
//напишите тут ваш код
    }
}
