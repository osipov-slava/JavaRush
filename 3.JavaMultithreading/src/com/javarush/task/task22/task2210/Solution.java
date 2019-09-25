package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] s = getTokens("level22.lesson13.task01", ".");

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> array = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) array.add(tokenizer.nextToken());

        String[] strings = new String[array.size()];
        array.toArray(strings);

        return strings;
    }
}
