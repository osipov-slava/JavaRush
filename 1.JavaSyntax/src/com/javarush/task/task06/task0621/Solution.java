package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grangFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grangFatherName);

        String grangMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grangMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName,catGrandFather,null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,null,catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat father,mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String s1="Cat name is "+name;

            if (mother == null)
                s1=s1+ ", no mother ";
            else
                s1=s1+ ", mother is " + mother.name;

            if (father == null)
                s1=s1+ ", no father ";
            else
                s1=s1+ ", father is " + father.name;

            return s1;
        }
    }

}
