package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> allLinesCopy = new ArrayList<String>(allLines);
        List<String> forRemoveLinesCopy = new ArrayList<String>(forRemoveLines);

        try {
            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader (inputStream);
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            inputStream.close();
            reader.close();


            FileInputStream fileInputStream = new FileInputStream(fileName1);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader readerFile = new BufferedReader(inputStreamReader);

            String strLine;

            while ((strLine = readerFile.readLine()) != null){
                allLines.add(strLine);
            }
            // нужно ли закрыть объекты?
            fileInputStream.close();
            inputStreamReader.close();
            readerFile.close();

            fileInputStream = new FileInputStream(fileName2);
            inputStreamReader = new InputStreamReader(fileInputStream);
            readerFile = new BufferedReader(inputStreamReader);

            while ((strLine = readerFile.readLine()) != null){
                forRemoveLines.add(strLine);
            }

            fileInputStream.close();
            inputStreamReader.close();
            readerFile.close();

            solution.joinData();

        } catch (IOException e) {
            System.out.println("IO Exception");
            allLines = new ArrayList<String>(allLinesCopy);
            forRemoveLines = new ArrayList<String>(forRemoveLinesCopy);
        }

    }


    public void joinData() throws CorruptedDataException, IOException {
        synchronized (Solution.class) {

            System.out.println(allLines);
            System.out.println(forRemoveLines);

            if (allLines.containsAll(forRemoveLines)) {
                allLines.removeAll(forRemoveLines);
            }
            else {
                allLines.clear();
                throw new CorruptedDataException();
            }

            System.out.println(allLines);
        }


    }
}
