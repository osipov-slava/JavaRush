package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name,lastname;
        private int age, height;
        private Human father,mother;

        public Human (String name){
            this.name=name;
            this.lastname="One";
        }

        public Human (String name, String lastname){
            this.name=name;
            this.lastname = lastname;
        }

        public Human (String name, String lastname, int age){
            this.name=name;
            this.lastname = lastname;
            this.age=age;
        }
//4
        public Human (String name, String lastname, int age, int height){
            this.name=name;
            this.lastname = lastname;
            this.age=age;
            this.height=height;
        }
        //5
        public Human (String name, int age, int height){
            this.name=name;
            this.age=age;
            this.height=height;
        }
//6
        public Human (String name, String lastname, int age, int height, Human father, Human mother){
            this.name=name;
            this.lastname = lastname;
            this.age=age;
            this.height=height;
            this.father=father;
            this.mother=mother;
        }
        //7
        public Human (String name, String lastname, Human father, Human mother){
            this.name=name;
            this.lastname = lastname;
            this.father=father;
            this.mother=mother;
        }
        //8
        public Human (){
            this.name="Nameless";
            this.lastname = "One";

        }

        public Human (String name, String lastname, int age, Human father, Human mother){
            this.name=name;
            this.lastname = lastname;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public Human (String name, Human father, Human mother){
            this.name=name;
            this.father=father;
            this.mother=mother;
        }



    }
}
