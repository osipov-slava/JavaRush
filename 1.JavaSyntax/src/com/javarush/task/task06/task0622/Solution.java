package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int [] a = new int[5];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5;i++){
            a[i] = Integer.parseInt(reader.readLine());
        }

        boolean flag=true;
        int b;

        do {
            flag=false;
            for (int i=0; i<5-1;i++){
                if (a[i]>a[i+1]) {
                    b=a[i];
                    a[i]=a[i+1];
                    a[i+1]=b;
                    flag=true;
                }
            }
        } while (flag);

        for (int i=0; i<5;i++) System.out.println(a[i]);
    }
}
