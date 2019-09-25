package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Iterator<Cat> iterator=cats.iterator();

        //while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        //}



        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> catSet = new HashSet<Cat>();
        Cat cat1 = new Cat ();
        Cat cat2 = new Cat ();
        Cat cat3 = new Cat ();
        catSet.add(cat1);
        catSet.add(cat2);
        catSet.add(cat3);
                //напишите тут ваш код. step 2 - пункт 2
        return catSet;
    }

    public static void printCats(Set<Cat> cats) {
        Iterator<Cat > iterator = cats.iterator();

        for (Cat cat : cats)
        {
            System.out.println(cat);
        }

    }

    public static class Cat{}

}
