package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Cat cat1=new Cat("Cat1");
        Cat cat2=new Cat("Cat2");
        Cat cat3=new Cat("Cat3");
        Cat cat4=new Cat("Cat4");
        Cat cat5=new Cat("Cat5");
        Cat cat6=new Cat("Cat6");
        Cat cat7=new Cat("Cat7");
        Cat cat8=new Cat("Cat8");
        Cat cat9=new Cat("Cat9");
        Cat cat0=new Cat("Cat0");
        Map<String ,Cat> cats = new HashMap<String ,Cat>();
        cats.put(cat1.name,cat1);
        cats.put(cat2.name,cat2);
        cats.put(cat3.name,cat3);
        cats.put(cat4.name,cat4);
        cats.put(cat5.name,cat5);
        cats.put(cat6.name,cat6);
        cats.put(cat7.name,cat7);
        cats.put(cat8.name,cat8);
        cats.put(cat9.name,cat9);
        cats.put(cat0.name,cat0);
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> cats = new HashSet<Cat>();
        for (Map.Entry<String ,Cat> entry : map.entrySet())
            cats.add(entry.getValue());
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
