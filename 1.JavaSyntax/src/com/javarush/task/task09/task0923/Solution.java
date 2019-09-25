package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();


        ArrayList<Character> chars = new ArrayList<Character>();
        ArrayList<Character> glasnye = new ArrayList<Character>();
        ArrayList<Character> soglasnye = new ArrayList<Character>();
        for (int i=0;i<string.length();i++)
            chars.add(string.charAt(i));
        for (int i=0;i<chars.size();i++){
            if (isVowel(chars.get(i)))
                glasnye.add(chars.get(i));
            else if (chars.get(i)!=' ')
                soglasnye.add(chars.get(i));
        }
        for (Character character : glasnye)
            System.out.print(character + " ");
        System.out.println();
        for (Character character : soglasnye)
            System.out.print(character + " ");
        System.out.println();

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}