package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top,left, width, height;//напишите тут ваш код

    public Rectangle (int top,int left, int width, int height){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=height;
    };

    public Rectangle (int top,int left, int width){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=width;
    };
    public Rectangle (int top,int left){
        this.top=top;
        this.left=left;
        this.width=0;
        this.height=0;
    };

    public Rectangle (Rectangle rectangle){
        Rectangle rectangle1= new Rectangle(rectangle.top,rectangle.left,rectangle.width,rectangle.height);
    }

    public static void main(String[] args) {

    }
}
