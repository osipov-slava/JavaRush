package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> strings=new HashSet<String>();
        strings.add("арбуз");
        strings.add("банан");
        strings.add("вишня");
        strings.add("груша");
        strings.add("дыня");
        strings.add("ежевика");
        strings.add("жень-шень");
        strings.add("земляника");
        strings.add("ирис");
        strings.add("картофель");

        for (String set : strings)
            System.out.println(set);

    }
}
