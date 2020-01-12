package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("ром", "паром"));//false
        System.out.println(isOneEditAway("колобок", "молоток"));//false
        System.out.println(isOneEditAway("ток", "сток"));//true
        System.out.println(isOneEditAway("приток", "притон"));//true
        System.out.println(isOneEditAway("оля", "Коля")); //true
        System.out.println(isOneEditAway("Оля", "Коля"));//false
        System.out.println(isOneEditAway("берег", "берег"));//true
        System.out.println(isOneEditAway("a", ""));//true
        System.out.println(isOneEditAway("", ""));//true
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;
        if (Math.abs(first.length() - second.length()) >= 2) return false;

        first = first + " ";
        second = second + " ";
        for (int i = 0; i < first.length(); i++) {

            //если символы совпадают
            if (first.charAt(i) == second.charAt(i)) continue;
            //если не совпадают
            switch (first.length() - second.length()) {
                //если строки одной длины
                case 0: {
                    first = first.substring(0, i) + first.substring(i + 1);
                    second = second.substring(0, i) + second.substring(i + 1);
                    break;
                }
                //если одна строка длинее другой
                case 1: {
                    first = first.substring(0, i) + first.substring(i + 1);
                    break;
                }
                case -1: {
                    second = second.substring(0, i) + second.substring(i + 1);
                    break;
                }
            }

            if (first.equals(second)) return true;
            else return false;
        }
        return true;
    }
}
