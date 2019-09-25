package com.javarush.task.task20.task2002;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("123", null);
            OutputStream outputStream = new FileOutputStream("1.txt");
            InputStream inputStream = new FileInputStream("1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Petrov");
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            Date bd = new Date();
            user1.setBirthDate(bd);
            javaRush.users.add(user1);


            User user2 = new User();
            user2.setFirstName("Elena");
            user2.setLastName("Kovaleva");
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            bd = new Date();
            user2.setBirthDate(bd);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.equals(javaRush)) System.out.println("True!");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int size;
            if (users == null) size = 0;
            else size = users.size();
            outputStream.write(size);

            for (int i = 0; i < users.size(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(users.get(i).getFirstName() + "\n" +
                        users.get(i).getLastName() + "\n" +
                        users.get(i).getCountry().toString() + "\n" +
                        users.get(i).isMale() + "\n" +
                        users.get(i).getBirthDate().getTime() + "\n");
                outputStream.write(stringBuilder.toString().getBytes());

            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int size = inputStream.read();
            if (size == 0) return;

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            for (int i = 0; i < size; i++) {
                users.add(new User());

                users.get(i).setFirstName(reader.readLine());
                users.get(i).setLastName(reader.readLine());
                String c = reader.readLine();
                User.Country country = User.Country.valueOf(c);
                users.get(i).setCountry(country);
                users.get(i).setMale(Boolean.parseBoolean(reader.readLine()));

                long l = Long.parseLong(reader.readLine());
                Date date = new Date(l);
                users.get(i).setBirthDate(date);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
