package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String string = bufferedReader.readLine(); //читаем строку с клавиатуры
        int sum=0;
        while (!string.equals("сумма")){
            int a = Integer.parseInt(string);
            sum=sum+a;
            string = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}
