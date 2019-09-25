package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human son1= new Human("S1",true,5);
        Human son2= new Human("S2",true,3);
        Human daughter= new Human("D",false,1);
        Human father= new Human("F",true,26,son1,son2,daughter);
        Human mother= new Human("M",false,25,son1,son2,daughter);
        Human grandFather1= new Human("GF1",true,55,father);
        Human grandFather2= new Human("GF2",true,54,mother);
        Human grandMother1= new Human("GM1",false,60,father);
        Human grandMother2= new Human("GM2",false,57,mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);



    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children=new ArrayList<Human>();

        public Human (String name,boolean sex, int age, Human ... children){ //образуется обычный массив children []
            this.name=name;
            this.sex=sex;
            this.age=age;

            if (children.length>0){
                for (int i=0;i<children.length;i++)
                    this.children.add(children[i]);
            }
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
