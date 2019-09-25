package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        return (this.age*0.2+this.weight*0.2+this.strength*0.6)
            > (anotherCat.age*0.2+anotherCat.weight*0.2+anotherCat.strength*0.6);//напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
