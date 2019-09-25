package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception{
            wheels = new ArrayList<>();
            String[] strings = loadWheelNamesFromDB();
            if (strings == null) throw new Exception();
            if (strings.length != 4) throw new Exception();
            try {
                for (String s: strings) {
                    System.out.println(s);
                    wheels.add(Wheel.valueOf(s));
                }
            } catch (Exception e) {
                throw new Exception(e);
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception{
        Car car = new Car();
    }
}
