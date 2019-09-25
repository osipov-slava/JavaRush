package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
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
        if (a!=0) {
            if (a>0) System.out.print("положительное ");
            else System.out.print("отрицательное ");
            if (a%2 == 0) System.out.println("четное число");
            else System.out.println("нечетное число");
        }
        else System.out.println("ноль");
    }
}
