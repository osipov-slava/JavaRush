package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        VeryComplexClass veryComplexClass2 = (VeryComplexClass)veryComplexClass.clone();
    }

    public static void main(String[] args) throws Exception{
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.veryComplexMethod();
    }
}
