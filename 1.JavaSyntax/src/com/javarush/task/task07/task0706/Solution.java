package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int [] a=new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int even=0,odd=0;

        for (int i=0;i<a.length;i++) {
            a[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) even = even + a[i];
            else odd = odd + a[i];
        }

        if (odd>even) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        if (odd<even) System.out.println("В домах с четными номерами проживает больше жителей.");
        //напишите тут ваш код
    }
}
