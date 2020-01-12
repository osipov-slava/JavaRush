package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        long iBit = 1L << i;
        long jBit = 1L << j;
        boolean firstBit = (number & iBit) == 0 ? false : true;
        boolean secondBit = (number & jBit) == 0 ? false : true;

        if (firstBit) {
            number |= 1L << j;
        } else {
            number &= ~(1L << j);
        }
        if (secondBit) {
            number |= 1L << i;
        } else {
            number &= ~(1L << i);
        }
        return number;
    }
}
