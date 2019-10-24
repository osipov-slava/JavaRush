package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();

        for (Class cl: classes) {
            List listInterfaces = new ArrayList();
            listInterfaces.addAll(Arrays.asList(cl.getInterfaces()));
            listInterfaces.addAll(Arrays.asList(cl.getSuperclass().getInterfaces()));
            try {
                if (listInterfaces.contains(List.class)
                        && Modifier.isPrivate(cl.getModifiers())
                        && Modifier.isStatic(cl.getModifiers())){
                    Constructor constructor = cl.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Method method = cl.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);

                    try {
                        method.invoke(constructor.newInstance(), 2);
                        //method.invoke(cl,2);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        if (e.getCause().toString().contains("IndexOutOfBoundsException")){
                            return cl;
                        };
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
