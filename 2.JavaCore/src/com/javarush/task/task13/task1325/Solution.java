package com.javarush.task.task13.task1325;

import java.awt.*;

/* 
Компиляция программы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BigFox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());
    }

    public interface Animal {
        default Color getColor(){return Color.GRAY;};
    }

    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox";
        }

    }

    public static class BigFox extends Fox {

    }

}
