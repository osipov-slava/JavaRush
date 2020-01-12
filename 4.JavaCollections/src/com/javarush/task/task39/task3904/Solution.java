package com.javarush.task.task39.task3904;

import java.util.ArrayList;
import java.util.List;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0;
        List<Long> longList = new ArrayList<>(n);
        longList.add(1L);
        longList.add(1L);
        longList.add(2L);
        for (int i = 3; i <= n; i++) {
            longList.add(longList.get(i - 1) + longList.get(i - 2) + longList.get(i - 3));
        }
        return longList.get(n);
    }
}

