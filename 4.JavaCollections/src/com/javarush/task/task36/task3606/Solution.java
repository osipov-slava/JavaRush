package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File folder = new File(packageName);
        //загрузка всех классов в List
        File[] listOfFiles = folder.listFiles();
            MyClassLoader classLoader = new MyClassLoader();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".class")) {
                    Class clazz = classLoader.findClass(listOfFiles[i].toString());
                    hiddenClasses.add(clazz);
                }

            }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            for (Class clazz: hiddenClasses) {
                if ((HiddenClass.class.isAssignableFrom(clazz))
                        && clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                    Constructor ctor = clazz.getDeclaredConstructor();
                    ctor.setAccessible(true);
                    HiddenClass hc = (HiddenClass) ctor.newInstance();
                    return hc;
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    class MyClassLoader extends ClassLoader {
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
}

