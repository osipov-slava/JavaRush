package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings= new ArrayList<String>();

        for (int i=0;i<10;i++) strings.add(reader.readLine());

        ArrayList<String> result = doubleValues(strings);

        for (String x : result)
            System.out.println(x);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i=0;i<list.size();i=i+2){
            list.add(i+1,list.get(i));
        }
        return list;
    }
}
