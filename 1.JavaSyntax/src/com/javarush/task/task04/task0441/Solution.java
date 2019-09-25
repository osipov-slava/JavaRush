package com.javarush.task.task04.task0441;


/* 
Как-то средненько
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
        int a1 = Integer.parseInt(s1); //преобразовываем строку в число.
        int a2 = Integer.parseInt(s2); //преобразовываем строку в число.
        int a3 = Integer.parseInt(s3); //преобразовываем строку в число.
        int i=0;

        if (a1>a2) {i=a1;a1=a2;a2=i;}
        if (a2>a3) {i=a2;a2=a3;a3=i;}
        if (a1>a2) {i=a1;a1=a2;a2=i;}

        System.out.println(a2);
//напишите тут ваш код
    }
}
