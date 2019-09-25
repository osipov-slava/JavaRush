package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList <Cat> cats=new ArrayList <Cat>();//напишите тут ваш код

    public Cat() {

    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            Cat cat= new Cat();
            cats.add(cat);
        }
        printCats();
    }

    public static void printCats() {
        for(Cat state : cats){
            System.out.println(state);//напишите тут ваш код
        }
    }
}
