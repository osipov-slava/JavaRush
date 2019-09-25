package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        do {
            key = reader.readLine();
            if (key.equals("user")) {
                person = new Person.User();
            }
            else if (key.equals("loser")) {
                person = new Person.Loser();
            }
            else if (key.equals("coder")) {
                person = new Person.Coder();
            }
            else if (key.equals("proger")) {
                person = new Person.Proger();
            }
            else break;

            doWork(person); //вызываем doWork

        } while (true);
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            Person.User user = (Person.User)person;
            user.live();
        }
        else if (person instanceof Person.Loser) {
            Person.Loser loser = (Person.Loser)person;
            loser.doNothing();
        }
        else if (person instanceof Person.Coder) {
            Person.Coder coder = (Person.Coder)person;
            coder.writeCode();
        }
        else if (person instanceof Person.Proger) {
            Person.Proger proger = (Person.Proger)person;
            proger.enjoy();
        }

    }
}
