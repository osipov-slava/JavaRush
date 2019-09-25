package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);

        } catch (Exception e) {
            exceptions.add(e);
        }


        try {
            String str = "test" ;
            char ch = str.charAt(4);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i[] = {1,2,3} ;
            i[3]=5;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String person = null;
            person.toString();

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer.parseInt("piouo");

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] myArray;
            myArray = new int[-2];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            InputStream inStream = new FileInputStream("c:/source.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inStream);
            inputStreamReader.close();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            OutputStream outStream = new FileOutputStream("h:/source.txt");
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outStream);
            outputStreamWriter.write("sfdgsfdgsfd");
            outputStreamWriter.close();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
