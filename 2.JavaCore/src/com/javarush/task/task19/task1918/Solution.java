package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static String tag;
    public static List<Integer> starts = new ArrayList<>();
    public static List<Integer> ends = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        tag = args[0];

        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String file = readerConsole.readLine();
        readerConsole.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        while (readerFile.ready()){
            sb.append(readerFile.readLine());
        }
        readerFile.close();

        // Поиск по строке
        int lastPos = 0;
        while (lastPos < sb.length())
            lastPos = findTag(sb.toString(),lastPos);

        //Вывод
        for (int i = 0; i < starts.size(); i++) {
            System.out.println(sb.substring(starts.get(i),ends.get(i)));
        }
    }

    private static int findTag(String str, int begin){
        Pattern pStart = Pattern.compile("<" + tag);
        Pattern pEnd = Pattern.compile("</" + tag + ">");
        Matcher mStart = pStart.matcher(str);
        Matcher mEnd = pEnd.matcher(str);
        mStart.find(begin); int start = mStart.start();
        mEnd.find(start); int end = mEnd.end();
        //Создать новую запись
        starts.add(start); ends.add(end);
        int pos = ends.size()-1;

        //А если вложенных тегов несколько?
        if (mStart.find() && mStart.start()<end) {//если найден вложенный тэг
                end = findTag(str, mStart.start());//рекурсия
                mEnd.find(end);//найти следующий закрывающий тэг, начиная с курсора
                end = mEnd.end();
                ends.set(pos, end); //обновляем необходимую запись

        }

        return end; //возвращаем курсор поиска
    }
}
