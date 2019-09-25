package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException,ParseException{
        /*PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner( "Фимилия Имя Отчество 01 01 2019\n"
                + "Иванов Иван Иванович 31 12 1950\n" +
        "Петров Петр Петрович 31 12 1957\n"));
        personScannerAdapter.read();*/
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        PersonScannerAdapter (Scanner scanner){
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String [] s = fileScanner.nextLine().split(" ",4);
            Date date = null;
            try {
                date = new SimpleDateFormat("d M y", Locale.ENGLISH).parse(s[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = new Person(s[1],s[2],s[0], date);
            System.out.println(person);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
