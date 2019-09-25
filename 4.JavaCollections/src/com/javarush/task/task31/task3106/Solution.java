package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {

    public static void main(String[] args) throws IOException{

        if (!(args.length > 1)) return;
        Arrays.sort(args, 1, args.length);

        List<InputStream> files = new ArrayList<>();
//соединяем файлы
        for (int i = 1; i < args.length; i++) {
            files.add(new FileInputStream(args[i]));
        }

        ZipInputStream zis = new ZipInputStream (new SequenceInputStream(Collections.enumeration(files)));
        ZipEntry ze;

        FileOutputStream fos = new FileOutputStream (args[0]);

        byte[] buffer = new byte[1024*10];
        while ((ze = zis.getNextEntry()) != null) {
            int byteBuffer;
            while ((byteBuffer = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, byteBuffer);
            }
            zis.closeEntry();
        }

        zis.close();
        fos.close();
    }
}
