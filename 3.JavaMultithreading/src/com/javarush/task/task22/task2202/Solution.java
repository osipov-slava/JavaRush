package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush -"));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        int end = -1;
        for (int i = 0; i < 4; i++) {
            end = string.indexOf(" ", end + 1);
            if (end == -1) throw new TooShortStringException();
        }
        end = string.indexOf(" ", end + 1);
        if (end == -1) end = string.length();

        return string.substring(string.indexOf(" ", 0) + 1, end);
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException() {
            super();
        }
    }
}
