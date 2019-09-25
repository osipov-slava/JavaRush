package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long[][] matrix = new long[10][21];
    private static Map<String,Long> map = new HashMap<>();

    static {
        for (int i = 1; i < 10; i++)
            for (int j = 1; j < 21; j++)
                matrix[i][j] = (long) Math.pow (i, j);

        for (int i = 0; i <= 9; i++) {
            map.put("" + i, (long) i);
        }
    }

    public static long sumStepen (int [] num){
        long sum = 0;
        int M = num.length;
        for (int i = 0; i < M ; i++) {
            sum += matrix[num[i]][M];
        }
        return sum;
    }

    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<Long>();
        int a = 0;

        //переводим число в массив чисел
        for (long i = 1; i < N; i++) {
             //количество цифр
            long k = i;
            int M = (int) (Math.log10 ((double) i) + 1);

            int [] num = new int[M];
            for (int j = 0; j < M; j++) {
                num[j] = (int) k % 10;
                k /= 10;
            }
            long sum = sumStepen(num);

            //Число Армстронга?
            if (i == sum && i != 0) list.add(i);
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }


    public static void main(String[] args) {
        long start = new Date().getTime();
        long[] res = getNumbers(54775807L);//9223372036854775807
        System.out.println(Arrays.toString(res));
        long end = new Date().getTime();
        long time = end - start;
        System.out.println(time + " ms");
    }
}
