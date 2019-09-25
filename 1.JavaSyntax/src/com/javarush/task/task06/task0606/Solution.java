package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine(); //читаем строку с клавиатуры
        int a = Integer.parseInt(s1);//for (int i=0; i<s1.length();i++){
        do {
            int b=a-a/10*10;
            a=a/10;
            if (b%2==0) even++;
            else odd++;
        } while (a!=0);
        System.out.println("Even: "+even +" Odd: "+odd);//преобразовываем строку в число.s1.charAt(i)

    }
}
