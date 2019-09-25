package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> inData = new ArrayList<Integer>();
        ArrayList<Integer> div3 = new ArrayList<Integer>();
        ArrayList<Integer> div2 = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();

        for (int i=0; i<20; i++)
            inData.add(Integer.parseInt(reader.readLine()));

        for (int i=0; i<inData.size();i++){
            if (inData.get(i)%3==0) div3.add(inData.get(i));
            if (inData.get(i)%2==0) div2.add(inData.get(i));
            if (inData.get(i)%2!=0 && inData.get(i)%3!=0) other.add(inData.get(i));

        }

        printList(div3);
        printList(div2);
        printList(other);

    }

    public static void printList(List<Integer> list) {
        for (Integer i : list)
            System.out.println(i);
    }
}
