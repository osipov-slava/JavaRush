package com.javarush.task.task20.task2001;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("osipov", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            if (ivanov.equals(somePerson)) System.out.println("True");;
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //выводим имя Хумана
            outputStream.write(this.name.length());
            outputStream.write(this.name.getBytes());

            //выводим длину массива активов
            int size = this.assets != null ? this.assets.size() : 0;
            outputStream.write(size);
            // если массив не пустой
            if (size > 0) {
                for (Asset asset: this.assets) {
                    //выводим длину актива и наименование
                    outputStream.write(asset.getName().length());
                    outputStream.write(asset.getName().getBytes());
                    //выводим double в виде 8 байт
                    ByteBuffer bbDouble = ByteBuffer.allocate(8);
                    bbDouble.putDouble(asset.getPrice());
                    outputStream.write(bbDouble.array());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int length = inputStream.read();
            byte[] nameByte = new byte[length];
            inputStream.read(nameByte);
            this.name = new String(nameByte);

            int assetsLength = inputStream.read();

            for (int i = 0; i < assetsLength; i++) {
                // читаем наименование актива
                length = inputStream.read();
                byte[] nameAsset = new byte[length];
                inputStream.read(nameAsset);

                // читаем стоимость актива
                byte[] priceAsset = new byte[8];
                inputStream.read(priceAsset);
                double d = ByteBuffer.wrap(priceAsset).getDouble();

                assets.add(new Asset(new String(nameAsset), d));
            }

        }
    }
}
