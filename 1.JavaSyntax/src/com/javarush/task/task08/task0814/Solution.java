package com.javarush.task.task08.task0814;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int[] a= {3,45,654,5,6,43,2,1,865,26,
                654354,650,34,879,7,8,9,99,24,23};
        for (int i = 0; i < a.length; i++) hashSet.add(a[i]);

        return hashSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext())        //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
            int a = iterator.next();
            if (a>10)
                iterator.remove();
        }
        return set;

    }

    public static void main(String[] args) {

    }
}
