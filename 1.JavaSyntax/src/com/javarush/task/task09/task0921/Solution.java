package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        List<Integer> arrayList=new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            while (true) {
                arrayList.add(Integer.parseInt(reader.readLine())); //преобразовываем строку в число.
            }

        }
        catch (Exception e){
            for (Integer al:arrayList)
                System.out.println(al);
        }


    }
}
