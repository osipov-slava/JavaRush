package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileOutputStream outputStream2 = new FileOutputStream(file2);
        FileOutputStream outputStream3 = new FileOutputStream(file3);
        byte[] buffer = null;
        int count = 0;
        if (inputStream1.available() > 0) {
            //читаем весь файл одним куском
            buffer = new byte[inputStream1.available()];
            count = inputStream1.read(buffer);
        }

        int bytes1, bytes2;
        // если файл не пустой
        if (count != 0) {

            // если количество байт четное
            if (count % 2 == 0) {
                bytes1 = bytes2 = count / 2;
            }
            else {
                bytes2 = count / 2;
                bytes1 = bytes2 + 1;
            }
            // запись в 2 файла
            outputStream2.write(buffer, 0, bytes1);
            outputStream3.write(buffer, bytes1, bytes2);
        }

        inputStream1.close();
        outputStream2.close();
        outputStream3.close();
    }
}
