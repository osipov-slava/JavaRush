package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c": {
                Date date = convertStringToDate(args[3]);
                if (args[2].equals("м")) allPeople.add(Person.createMale(args[1],date));
                else allPeople.add(Person.createFemale(args[1],date));
                System.out.println(allPeople.size()-1);
                break;
            }
            case "-u": {
                Date date = convertStringToDate(args[4]);
                int i = Integer.parseInt(args[1]);
                allPeople.get(i).setName(args[2]);
                if (args[3].equals("м")) allPeople.get(i).setSex(Sex.MALE);
                else allPeople.get(i).setSex(Sex.FEMALE);
                allPeople.get(i).setBirthDate(date);
                break;
            }
            case "-d": {
                int i = Integer.parseInt(args[1]);
                allPeople.get(i).setName(null);
                allPeople.get(i).setSex(null);
                allPeople.get(i).setBirthDate(null);
                break;
            }
            case "-i": {
                int i = Integer.parseInt(args[1]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                String sex = null;
                if (allPeople.get(i).getSex() == Sex.MALE) sex = "м";
                else if (allPeople.get(i).getSex() == Sex.FEMALE) sex = "ж";
                System.out.println(allPeople.get(i).getName() + " " + sex + " " +
                        dateFormat.format(allPeople.get(i).getBirthDate()));
                break;
            }
            default: break;

        }
    }

    private static Date convertStringToDate (String string){
        Date date = new Date();
        String[] strDate = string.split("/");
        date.setDate(Integer.parseInt(strDate[0]));
        date.setMonth(Integer.parseInt(strDate[1])-1);
        date.setYear(Integer.parseInt(strDate[2])-1900);
        return date;
    }
}
