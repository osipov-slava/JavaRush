package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.equals("")) return 0;

        Set<Character> characterSet = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!characterSet.contains(s.charAt(i))) {
                characterSet.add(s.charAt(i));
                if (maxLength < characterSet.size()) maxLength = characterSet.size();
            } else {
                characterSet.clear();
                characterSet.add(s.charAt(i));
            }
        }

        return maxLength;
    }
}
