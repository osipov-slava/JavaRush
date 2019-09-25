package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top,left, width, height;//напишите тут ваш код

    public void initialize (int top,int left, int width, int height){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=height;
    };

    public void initialize (int top,int left, int width){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=width;
    };
    public void initialize (int top,int left){
        this.top=top;
        this.left=left;
        this.width=0;
        this.height=0;
    };
    public void initialize (Rectangle rectangle){
        Rectangle rectangle1= new Rectangle();
        rectangle1.initialize (rectangle.top,rectangle.left,rectangle.width,rectangle.height);

    }




    public static void main(String[] args) {

    }
}
