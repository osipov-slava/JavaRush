package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

import static com.javarush.task.task39.task3905.Color.*;

public class Solution {
    public static void main(String[] args) {
        Color[][] matrix = {
                {BLUE, BLUE, RED, BLUE/*заливаем с этой точки*/},
                {BLUE, BLUE, BLUE, BLUE},
                {YELLOW, BLUE, RED, GREEN},
                {BLUE, RED, RED, GREEN},
                {BLUE, BLUE, RED, BLUE}};

        PhotoPaint photoPaint = new PhotoPaint();
        System.out.println(photoPaint.paintFill(matrix, - 1, 0, YELLOW));//false
        System.out.println(photoPaint.paintFill(matrix, 2, 5, YELLOW));//false
        System.out.println(photoPaint.paintFill(matrix, 3, 0, YELLOW));//true
        /*
                {YELLOW, YELLOW, RED, YELLOW},
                {YELLOW, YELLOW, YELLOW, YELLOW},
                {YELLOW, YELLOW, RED, GREEN},
                {BLUE, RED, RED, GREEN},
                {BLUE, BLUE, RED, BLUE}
         */
        System.out.println(photoPaint.paintFill(matrix, 0, 4, BLUE));//false
    }
}
