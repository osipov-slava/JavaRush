package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String folder = reader.readLine();
        Path folderPath = Paths.get(folder);
        if (!Files.isDirectory(folderPath)) {
            System.out.println(folder + " - не папка");
            return;
        }

        final Solution solution = new Solution();
        Files.walkFileTree(folderPath, solution);

        System.out.println("Всего папок - " + countFolders);
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + countBytes);

    }

    private static int countFolders = -1;//не включаем исходную папку
    private static int countFiles;
    private static long countBytes;

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        countFolders++;
        return super.postVisitDirectory(dir, exc);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFiles++;
        countBytes += Files.size(file);
        return super.visitFile(file, attrs);
    }
}
