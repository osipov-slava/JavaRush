package com.javarush.task.task35.task3507;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution extends ClassLoader {

    public static void main(String[] args) {

        Set<? extends Animal> allAnimals = getAllAnimals("G:\\OneDriveCopy\\OneDrive\\Программирование\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task35\\task3507\\data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Solution solution = new Solution();
        Set<Class<?>> classSet = new HashSet<>();

        File folder = new File(pathToAnimals);

        //загрузка всех классов в сет
        File[] listOfFiles = folder.listFiles();
        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".class")) {
                    Class clazz = solution.loadClass(listOfFiles[i].toString());
                    classSet.add(clazz);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //проверка на выполнение условий
        Set<Animal> setAnimal = new HashSet<>();
        for (Class cls: classSet) {
            Constructor[] constructors = cls.getConstructors();
            for (Constructor constructor: constructors) {
                if (constructor.getParameterCount()==0
                        && constructor.getModifiers() == Modifier.PUBLIC
                        && Animal.class.isAssignableFrom(cls))
                    try {
                        setAnimal.add((Animal)cls.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
        }

        return setAnimal;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            Path file = Paths.get(name);
            byte[] bytes = Files.readAllBytes(file);
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }


}
