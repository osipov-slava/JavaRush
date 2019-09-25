package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandfatherF = new Human("Борис Михайлович",true,50);
        Human grandfatherM = new Human("Василий Петрович",true,55);
        Human grandmotherF = new Human("Марья Афанасьевна",false,49);
        Human grandmotherM = new Human("Лидия Егоровна",false,52);
        Human father = new Human("Петр Николаевич",true,26,grandfatherF,grandmotherF);
        Human mother = new Human("Елена Васильевна",false,22,grandfatherM,grandmotherM);
        Human son = new Human("Саша",true,3,father,mother);
        Human daughter1 = new Human("Люда",false,2,father,mother);
        Human daughter2 = new Human("Настя",false,1,father,mother);

        System.out.println(grandfatherF);
        System.out.println(grandmotherF);
        System.out.println(grandfatherM);
        System.out.println(grandmotherM);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter1);
        System.out.println(daughter2);
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public Human father,mother;

        public Human (String name, boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        public Human (String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















