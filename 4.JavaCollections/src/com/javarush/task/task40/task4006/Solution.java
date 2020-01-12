package com.javarush.task.task40.task4006;


import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = (new Socket(url.getHost(), 80));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, false);
//            GET social.html HTTP/1.1
//            Host: javarush.ru
//            User-Agent: Mozilla/5.0
//            Accept: text/html
//            Connection: close
            out.println("GET "+ url.getFile() + " " + url.getProtocol());
            out.println("Host: "+ url.getHost());
            out.println("User-Agent: Mozilla/5.0");
            out.println("Accept: text/html");
            out.println("Connection: close");
            out.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            out.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

