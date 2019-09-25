package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader readerFile = new BufferedReader(new FileReader(args[0]));
        while (readerFile.ready()) {
            String str = readerFile.readLine();
            String[] strings = str.split(" ");
            int day = Integer.parseInt(strings[strings.length-3]);
            int month = Integer.parseInt(strings[strings.length-2]);
            int year = Integer.parseInt(strings[strings.length-1]);
            String name = str.substring(0, str.length()-strings[strings.length-3].length()
                    -strings[strings.length-2].length()
                    -strings[strings.length-1].length()-3);
            System.out.println(name);
            Date date = stringToDate (day, month, year);

            PEOPLE.add(new Person(name,date));

        }
        readerFile.close();
    }

    static Date stringToDate (int day, int month, int year){
        Date d = new Date();
        d.setDate(day);
        d.setMonth(month-1);
        d.setYear(year-1900);
        return d;
    }
}
