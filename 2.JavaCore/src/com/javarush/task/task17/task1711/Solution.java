package com.javarush.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c": synchronized (allPeople){
                for(int i = 1; i < args.length; i +=3){
                    createPeople(args[i], args[i +1], args[i +2]);
                }
                break;
            }
            case "-u": synchronized (allPeople){
                for(int i = 1; i < args.length; i +=4){
                    updatePeople(args[i], args[i +1], args[i +2], args[i +3]);
                }
                break;
            }
            case "-d": synchronized (allPeople){
                for(int i = 1; i < args.length; i++){
                    deletePeople(args[i]);
                }
                break;
            }
            case "-i": synchronized (allPeople){
                for(int i = 1; i < args.length; i++){
                    informationOfPeople(args[i]);
                }
                break;
            }


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

    private static void printNamePersons (){
        for (Person p: allPeople) {
            System.out.println(p.getName());
        }
    }

    private static void createPeople (String name, String sex, String strDate){
        Date date = convertStringToDate(strDate);
        if (sex.equals("м")) allPeople.add(Person.createMale(name,date));
        else allPeople.add(Person.createFemale(name,date));
        System.out.println(allPeople.size()-1);
    }

    public static void updatePeople (String id, String name, String sex, String strDate){
        Date date = convertStringToDate(strDate);
        int i = Integer.parseInt(id);
        allPeople.get(i).setName(name);
        if (sex.equals("м")) allPeople.get(i).setSex(Sex.MALE);
        else allPeople.get(i).setSex(Sex.FEMALE);
        allPeople.get(i).setBirthDate(date);
    }

    public static void deletePeople (String id){
        int i = Integer.parseInt(id);
        allPeople.get(i).setName(null);
        allPeople.get(i).setSex(null);
        allPeople.get(i).setBirthDate(null);
    }

    public static void informationOfPeople (String id){
        int i = Integer.parseInt(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        String sex = null;
        if (allPeople.get(i).getSex() == Sex.MALE) sex = "м";
        else if (allPeople.get(i).getSex() == Sex.FEMALE) sex = "ж";
        System.out.println(allPeople.get(i).getName() + " " + sex + " " +
                dateFormat.format(allPeople.get(i).getBirthDate()));
    }
}
