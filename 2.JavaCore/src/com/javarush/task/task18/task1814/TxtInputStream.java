package com.javarush.task.task18.task1814;

import java.io.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException{
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        new TxtInputStream(reader.readLine());

    }
}

