package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(s1); //преобразовываем строку в число.

        boolean chetnechet, polozhotriz;
        if ((a>0) && (a<1000)) {
            if (a%2 == 0) System.out.print("четное ");
            else System.out.print("нечетное ");
            if (a>99) System.out.println("трехзначное число");
            else if (a>9) System.out.println("двузначное число");
            else System.out.println("однозначное число");
        }

    }
}
