package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings=new ArrayList<String>();
        Collections.addAll(strings,"мама", "мыла", "раму");
        for (int i=0; i<strings.size();i=i+2){
            strings.add(i+1,"именно");
        }

        for (String str : strings)
            System.out.println(str);


    }
}
