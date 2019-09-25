package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<10;i++)
            list.add(Integer.parseInt(reader.readLine()));

        ArrayList<Integer> list1 = new ArrayList<>();

        list1.add(list.get(0));
        int maxlenght = 0;

        for (int i=1;i<10;i++){
            if (list1.get(0)==list.get(i))
                list1.add(list.get(i));
            else {
                if (maxlenght<list1.size()) maxlenght=list1.size();
                list1.clear();
                list1.add(list.get(i));
            }

        }
        if (maxlenght<list1.size()) maxlenght=list1.size();
        System.out.println(maxlenght);
    }
}