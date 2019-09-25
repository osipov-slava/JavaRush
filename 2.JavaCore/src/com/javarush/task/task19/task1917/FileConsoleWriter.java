package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter  {
    private FileWriter fileWriter;

    FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }
    FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }
    FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName,append);
    }

    public static void main(String[] args) {
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        String s = String.valueOf(cbuf);
        System.out.print(s.substring(off, off + len));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.print(c);
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.print(str);
    }

    public void write(String str, int off, int len) throws IOException{
        this.fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.print(cbuf);
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }
}
