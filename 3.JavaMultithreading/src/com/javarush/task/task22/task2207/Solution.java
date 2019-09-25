package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder fileData = new StringBuilder();

        while (readerFile.ready()) {
            String str = readerFile.readLine() + " ";
            fileData.append(str);
        }
        reader.close();
        readerFile.close();

        String str = fileData.toString();
        String[] strings = str.split(" ");

        List<String> arrayStrings = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arrayStrings.add(strings[i]);
        }

        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {return o1.compareTo(o2);}
        };
        arrayStrings.sort(comparator);

        while (arrayStrings.size() > 0){
            String right = arrayStrings.get(0);
            StringBuilder reverse = new StringBuilder(right).reverse();
            String sReverse = reverse.toString();
            arrayStrings.remove(0);
            int reverseExists = arrayStrings.indexOf(sReverse);
            if (reverseExists >= 0){
                arrayStrings.remove(reverseExists);

                Pair p = new Pair();
                p.first = right;
                p.second = sReverse;
                result.add(p);
            }
        }

        for (Pair p: result) {
            System.out.println(p.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
