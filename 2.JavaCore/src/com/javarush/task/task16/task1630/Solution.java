package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String fileContent = "";


        @Override
        public void run() {
            ArrayList<String> stringsFile = new ArrayList<>();
            try {

                FileInputStream fstream = new FileInputStream(this.fileName);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = fileReader.readLine()) != null){
                    stringsFile.add(strLine);
                }
                fileReader.close();
                fstream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i=0; i<stringsFile.size(); i++){
                fileContent += stringsFile.get(i) + " ";
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

    }

}
