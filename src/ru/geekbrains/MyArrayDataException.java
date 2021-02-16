package ru.geekbrains;

public class MyArrayDataException extends RuntimeException {
    private int i;
    private int j;
    private String z;

    public int getArrI() {
        return i;
    }

    public int getArrJ() {
        return j;
    }

    public String getWrongValue() {
     return z;
    }

    public MyArrayDataException(int i, int j, String z) {
        this.i = i;
        this.j = j;
        this.z = z;

    }
}
