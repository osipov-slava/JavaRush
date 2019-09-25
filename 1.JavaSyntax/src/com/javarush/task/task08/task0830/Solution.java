package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        String string = array[0];
        boolean sort;
        do {
            sort = true;
            for (int i=1; i<array.length; i++){// по массиву строкЪ{

                if (isGreaterThan(array[i-1],array[i])){
                    string=array[i];
                    array[i]=array[i-1];
                    array[i-1]=string;
                    sort=false;
                }



            }
        }while (!sort);




    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {

        return a.compareTo(b) > 0;
    }
}
