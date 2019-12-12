package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return FactoryException.class;
    }

    public static void main(String[] args) throws Exception{
    }

    public static class FactoryException {
        public static Throwable getException (Enum en){
            if (en == null) return new IllegalArgumentException();
            String message = en.name().charAt(0) + en.name().substring(1).toLowerCase().replace("_", " ");
            if (en.getDeclaringClass() == ApplicationExceptionMessage.class)
                return new Exception(message);
            else if (en.getDeclaringClass() == DatabaseExceptionMessage.class)
                return new RuntimeException(message);
            else if (en.getDeclaringClass() == UserExceptionMessage.class)
                return new Error(message);
            else return new IllegalArgumentException();
        }
    }
}