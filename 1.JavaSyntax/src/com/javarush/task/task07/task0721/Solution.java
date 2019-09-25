package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[20];

        int maximum;
        int minimum;

        for (int i=0;i<20;i++)
            a[i]=Integer.parseInt(reader.readLine());

        maximum=a[0];
        minimum=a[0];

        for (int x : a){
            if (maximum<x) maximum=x;
            if (minimum>x) minimum=x;
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
