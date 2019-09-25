package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a1 = Integer.parseInt(reader.readLine());
        if (a1 <= 0) throw new NumberFormatException();

        int a2 = Integer.parseInt(reader.readLine());
        if (a2 <= 0) throw new NumberFormatException();

        int nod = 0;


        System.out.println(searchNod(a1,a2));
    }

    public static int searchNod (int a1, int a2){

        while (a1 != 0 && a2 != 0){
            if (a1 > a2) a1 = a1 % a2;
            else a2 = a2 % a1;
        }

        return a1 + a2;
    }
}
