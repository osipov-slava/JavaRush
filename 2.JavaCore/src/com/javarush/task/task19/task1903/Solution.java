package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        /*
        int num = 501234567;
        String str = String.format("%010d",num);
        System.out.println(str);
        String s = String.format("+%d(%3s)%s-%s-%s", 38,
                str.substring(0,3), str.substring(3, 6), str.substring(6, 8), str.substring(8, 10));
        System.out.println(s);
        */
    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;

        IncomeDataAdapter (IncomeData data){
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String str = String.format("%010d", data.getPhoneNumber());
            return String.format("+%d(%3s)%s-%s-%s", data.getCountryPhoneCode(),
                    str.substring(0,3), str.substring(3, 6), str.substring(6, 8), str.substring(8, 10));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}