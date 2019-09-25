package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        //получить список файлов и запустить перебор
        List<String> fileNames = new ArrayList<>();
        File rootFile = new File(root);


        Queue<File> directories = new LinkedList<>();
        directories.add(rootFile);

        while (directories.peek() != null) {
            File[] filesFromDir = directories.remove().listFiles();
            for (File f : filesFromDir) {
                //если каталог, добавить в очередь каталогов
                if (f.isDirectory()) directories.offer(f);
                //если файл, добавить путь в искомый список
                else fileNames.add(f.getCanonicalPath());
            }
        }
        return fileNames;

    }

    public static void main(String[] args) throws IOException{
        List<String> list = new ArrayList<>();
        list = getFileTree("h:/test");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
