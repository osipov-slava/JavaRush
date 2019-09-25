package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stal", new Date("OCTOBER 2 1982"));
        map.put("Dtallone", new Date("JUNE 1 1980"));
        map.put("FRllone", new Date("JANUARY 1 1980"));
        map.put("KJallone", new Date("JUNE 1 1980"));
        map.put("Illone", new Date("FEBRUARY 1 1980"));
        map.put("TRne", new Date("SEPTEMBER 1 1980"));
        map.put("MNallone", new Date("MAY 1 1980"));
        map.put("DFllone", new Date("AUGUST 1 1980"));
        map.put("REllone", new Date("JULY 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<HashMap.Entry<String,Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            HashMap.Entry<String,Date> pair = iterator.next();
            Date date = pair.getValue();
            int month = date.getMonth();
            if (month>4 && month<8) iterator.remove();
            //if (name.equals(value)) count++;
        }

    }

    public static void main(String[] args) {
       // HashMap<String,Date> map = createMap();
       // removeAllSummerPeople(map);
       // System.out.println(map.size());
    }
}
