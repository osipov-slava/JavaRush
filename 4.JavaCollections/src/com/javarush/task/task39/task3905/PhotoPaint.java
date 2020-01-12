package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (x < 0 || y < 0 || y > image.length - 1 || x > image[0].length - 1) return false;
        if (image[y][x] == desiredColor) return false;
        paintPixel(image, x, y, desiredColor, image[y][x]);
        return true;
    }

    private void paintPixel(Color[][] image, int x, int y, Color desiredColor, Color oldColor) {
        image[y][x] = desiredColor;
        if (x - 1 >= 0 && image[y][x - 1] == oldColor) paintPixel(image, x - 1, y, desiredColor, oldColor);
        if (y - 1 >= 0 && image[y - 1][x] == oldColor) paintPixel(image, x, y - 1, desiredColor, oldColor);
        if (x + 1 < image[0].length && image[y][x + 1] == oldColor) paintPixel(image, x + 1, y, desiredColor, oldColor);
        if (y + 1 < image.length && image[y + 1][x] == oldColor) paintPixel(image, x, y + 1, desiredColor, oldColor);
    }
}
