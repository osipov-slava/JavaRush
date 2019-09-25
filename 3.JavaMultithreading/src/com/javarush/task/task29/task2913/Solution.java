package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a > b) {
            for (int i = 0; i <= (a - b); i++) {
                sb.append(String.valueOf(a - i));
                sb.append(" ");
            }
            return sb.toString().trim();

        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            for (int i = 0; i <= (b - a); i++) {
                sb.append(String.valueOf(a + i));
                sb.append(" ");
            }
            return sb.toString().trim();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}