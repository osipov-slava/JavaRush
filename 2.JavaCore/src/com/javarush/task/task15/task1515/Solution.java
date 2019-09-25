package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        try {
            A = Integer.parseInt(reader.readLine());
            B = Integer.parseInt(reader.readLine());
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

        try {
            inputStreamReader.close();
            reader.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());

        }
    }



    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
