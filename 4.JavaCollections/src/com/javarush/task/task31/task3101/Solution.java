package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        String path = args[0];
        File dir = new File(path);

        String resultFileAbsolutePath = args[1];
        File fileOut = new File(resultFileAbsolutePath);

        List<File> filesLess50bytes = new LinkedList<File>();
        filesLess50bytes = listFilesLess50bytes(dir, filesLess50bytes);

        filesLess50bytes = sortList(filesLess50bytes);

        //  переименовать файл
        File newFile = new File(fileOut.getParent()+"\\"+"allFilesContent.txt");
        FileUtils.renameFile (fileOut, newFile);

        readWriteBytes (newFile, filesLess50bytes);

    }

    //рекурсивная функция
    public static List listFilesLess50bytes (File dir, List<File> files){
    //получить список файлов и запустить перебор
        File[] filesFromDir = dir.listFiles();
        for (File f : filesFromDir) {
            //если каталог запустить себя
            if (f.isDirectory()) files = listFilesLess50bytes(f, files);
            // если длина <50bytes добавить в список
            else if (f.length() <= 50) files.add(f);
        }
        return files;
    }

    public static List sortList (List files){
        Comparator<File> comparator = new Comparator<File>(){
            @Override
            public int compare(File o1, File o2) {
                //сортировка по имени без пути
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }
        };
        files.sort(comparator);
        return files;
    }

    public static void readWriteBytes (File fileOut, List <File> files){
        //чтение и запись
        try {

            FileOutputStream outputStream = new FileOutputStream(fileOut, true);

            for (File f : files) {
                FileInputStream inputStream = new FileInputStream(f);
                if (inputStream.available() > 0) {
                    //читаем весь файл одним куском
                    byte[] buffer = new byte[inputStream.available()];
                    int count = inputStream.read(buffer);
                    outputStream.write(buffer, 0, count);
                    outputStream.write(0x0a);
                }
                inputStream.close();
            }

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
