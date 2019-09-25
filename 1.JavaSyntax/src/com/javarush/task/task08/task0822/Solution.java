package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min=array.get(0);
        for (int i=0; i<array.size();i++){
            if (array.get(i)<min) min=array.get(i);
        }

        // find minimum here — найти минимум тут
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());//преобразовываем строку в число.
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++)
            list.add(Integer.parseInt(reader.readLine()));

        return list;
    }
}
