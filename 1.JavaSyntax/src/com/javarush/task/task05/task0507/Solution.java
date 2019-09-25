package com.javarush.task.task05.task0507;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        double i=0,j=0,a=0;
        do {
            String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
            a = Double.parseDouble(s1); //преобразовываем строку в число.
            i=i+a;
            j++;
        } while (a!=-1);
        double k=(i+1)/(j-1);
        System.out.println(""+k);
    }
}

