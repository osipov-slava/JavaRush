package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix =
                       {{1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1}};
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int maxSize = 0;
        int currentSize = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //если левый верхний угол не равен нулю
                if (matrix[i][j] != 0) {
                    boolean squareIsFull;
                    do {
                        squareIsFull = true;
                        for (int k = 0; k < currentSize; k++) {
                            for (int l = 0; l < currentSize; l++) {
                                if (matrix[i + k][j + l] != 1) {
                                    squareIsFull = false;
                                    break;
                                }
                            }
                            if (!squareIsFull) break;
                        }
                        if (squareIsFull) {
                            maxSize = currentSize++;
                        }
                        //пока квадрат заполнен и не выходит за пределы массива
                    } while (squareIsFull
                            && (i + currentSize - 1) < matrix.length
                            && (j + currentSize - 1) < matrix[0].length);
                }
                if (j + currentSize >= matrix[0].length) break;
            }
            if (i + currentSize >= matrix.length) break;
        }
        return maxSize * maxSize;
    }
}
