package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        int[] arr1 = new int[]{4,2,4,3,5};
        int[] arr2 = new int[]{4,2};
        int[] arr3 = new int[]{4,2,4,6};
        int[] arr4 = new int[]{4,2,4,6,7,9,0};
        int[] arr5 = new int[]{};

        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
