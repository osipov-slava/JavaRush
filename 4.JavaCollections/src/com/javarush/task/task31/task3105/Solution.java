package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    private static List<ZipEntry> zipEntryList = new ArrayList<>();
    private static List<ByteArrayOutputStream> zipEntryBytes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get(args[0]);
        ZipEntry newZipEntry = new ZipEntry("new/" + fileName.getFileName().toString());

        FileInputStream zipFile = new FileInputStream(args[1]);
        ZipInputStream zip = new ZipInputStream(zipFile);
        ZipEntry zipEntry ;

        while ((zipEntry = zip.getNextEntry()) != null){

            if (zipEntry == null) break;
            if (zipEntry.toString().equals(newZipEntry.toString())) continue;
            zipEntryList.add(zipEntry);

            ByteArrayOutputStream bAOS = new ByteArrayOutputStream();

            byte[] b = new byte[1000];
            int d;
            while (true) {
                d = zip.read(b);
                if (d == -1) {
                    break;
                } else {
                    bAOS.write(b, 0, d);
                }
            }
            zipEntryBytes.add(bAOS);
            zip.closeEntry();
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));

        zipOutputStream.putNextEntry(new ZipEntry("new/" + fileName.getFileName().toString()));
        Files.copy(Paths.get(args[0]), zipOutputStream);

        for (int i = 0 ; i < zipEntryList.size(); i++) {

            zipOutputStream.putNextEntry(new ZipEntry(zipEntryList.get(i)));
            zipOutputStream.write(zipEntryBytes.get(i).toByteArray());
            zipOutputStream.closeEntry();
        }

        zip.close();
        zipOutputStream.close();

    }
}
