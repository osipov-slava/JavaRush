package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array1 = {1, 3, 2, 4};
        Integer[] array2 = {13, 8, 15, 5, 17};

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double mediana;
        if (array.length % 2 == 1) mediana = array[array.length / 2];
        else mediana = (double) (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        System.out.println(mediana);


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i1 = (int) Math.abs((double) o1 - mediana);
                int i2 = (int) Math.abs((double) o2 - mediana);
                return i1 - i2;
            }
        };

        Arrays.sort(array, comparator);
        return array;
    }
}
