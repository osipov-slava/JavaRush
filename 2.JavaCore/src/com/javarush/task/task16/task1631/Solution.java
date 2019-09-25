package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {

        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
         reader = ImageReaderFactory.getImageReader(ImageTypes.PNG);
         reader = ImageReaderFactory.getImageReader(ImageTypes.BMP);
         reader = ImageReaderFactory.getImageReader(null);
    }
}
