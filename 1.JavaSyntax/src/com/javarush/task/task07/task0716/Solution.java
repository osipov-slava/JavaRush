package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list.add("папка");
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> fixNew = new ArrayList<String>();

        for (int i=0; i<list.size();i++){
            String str = list.get(i);
            char [] ch = str.toCharArray();
            boolean rYes=false, lYes=false;

            for (char c : ch)
                if (c == 'р') rYes=true;
            for (char c : ch)
                if (c == 'л') lYes=true;

            if (!rYes && lYes) {
                fixNew.add(list.get(i));
                fixNew.add(list.get(i));
            }
            if (rYes && lYes)
                fixNew.add(list.get(i));
            if (!rYes && !lYes)
                fixNew.add(list.get(i));


        }
        return fixNew;
    }
}