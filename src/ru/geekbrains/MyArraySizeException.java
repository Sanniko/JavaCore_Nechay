package ru.geekbrains;

public class MyArraySizeException extends RuntimeException {
    private int width;
    private int height;

    public int getArrWidth() {
        return width;
    }

    public int getArrHeight() {
        return height;
    }

    public MyArraySizeException(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
