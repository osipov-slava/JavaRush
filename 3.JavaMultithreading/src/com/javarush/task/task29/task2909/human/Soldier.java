package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    public Soldier(String name, int age) {
        super(name, age);
    }

    private BloodGroup bloodGroup;

    public void setBloodGroup(int code) {
        switch (code) {
            case 1 : bloodGroup = BloodGroup.first(); break;
            case 2 : bloodGroup = BloodGroup.second(); break;
            case 3 : bloodGroup = BloodGroup.third(); break;
            case 4 : bloodGroup = BloodGroup.fourth(); break;
        }
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
