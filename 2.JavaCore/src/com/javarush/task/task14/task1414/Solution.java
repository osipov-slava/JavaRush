package com.javarush.task.task14.task1414;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7

        Movie movie = null;
        String string = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            string = reader.readLine();
            if (!("soapOpera".equals(string) ||
                    "cartoon".equals(string) ||
                    "thriller".equals(string))) {
                movie = MovieFactory.getMovie(string);
                break;
            }
            movie = MovieFactory.getMovie(string);
            System.out.println(movie.getClass().getSimpleName());
        } while (true);
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }

    static class Thriller extends Movie {

    }
    //Напишите тут ваши классы, пункт 3
}
