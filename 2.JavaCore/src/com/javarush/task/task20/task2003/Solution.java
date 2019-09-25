package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(file);
        load(fis);
        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();
        property.putAll(properties);
        property.store(outputStream,null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();
        property.load(inputStream);
        for (String name : property.stringPropertyNames()) {
            properties.put(name, property.getProperty(name));
        }
    }

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

        FileOutputStream fos = new FileOutputStream("2.txt");
        solution.save(fos);
        fos.close();
    }
}
