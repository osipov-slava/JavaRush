package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("asdfghjhgffdsaasdfdsa"));
    }

    public static boolean isPalindromePermutation(String s) {
        s = s.toUpperCase();
        Map<Character,Integer> charactersCount = new HashMap<>(256);
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (charactersCount.containsKey(ch)) charactersCount.put(ch, charactersCount.get(ch) + 1);
            else charactersCount.put(ch, 1);
        }
        int oddCountChar = 0;
        for (Map.Entry<Character,Integer> pair: charactersCount.entrySet()) {
            if (pair.getValue()%2 == 1) {
                oddCountChar++ ;
                if (oddCountChar > 1) return false;
            }
        }
        return true;
    }
}
