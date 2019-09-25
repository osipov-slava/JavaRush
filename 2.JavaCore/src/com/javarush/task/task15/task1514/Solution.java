package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(2.2, "lkjndkfj");
        labels.put(5.265, "df");
        labels.put(2d, "w45er");
        labels.put(34d, "dfgskm");
        labels.put((double)-345, "123");
    }
    public static void main(String[] args) {

        System.out.println(labels);
    }
}
