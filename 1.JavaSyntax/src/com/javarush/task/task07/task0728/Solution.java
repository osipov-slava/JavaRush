package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());


        }
        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        boolean sort=true;
        do{
            int b=array[0];
            sort=true;
            for (int i=1; i<array.length;i++){
                if (array[i-1]<array[i]) {
                    b=array[i];
                    array[i]=array[i-1];
                    array[i-1]=b;
                    sort=false;
                }
            }

        } while (!sort);
    }
}
