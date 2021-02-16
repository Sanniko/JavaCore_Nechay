package ru.geekbrains;

import static java.lang.String.valueOf;

public class Main {

    public static void main(String[] args) {
        //1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
        //  При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

        //2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
        //просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
        //ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        //MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

        //3 В методе main() вызвать полученный метод, обработать возможные исключения
        //MyArraySizeException и MyArrayDataException и вывести результат расчета.
        String[][] testArray = new String[4][4];

        testArray[0][0] = "1";
        testArray[0][1] = "5";
        testArray[0][2] = "7";
        testArray[0][3] = "4";

        testArray[1][0] = "3";
        testArray[1][1] = "5";
        testArray[1][2] = "7";
        testArray[1][3] = "2";

        testArray[2][0] = "t";
        testArray[2][1] = "#";
        testArray[2][2] = "6";
        testArray[2][3] = "8";

        testArray[3][0] = "9";
        testArray[3][1] = "2";
        testArray[3][2] = "1";
        testArray[3][3] = "3";

        try {
            arrSquare(testArray);
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива. Необходимый размер 4x4, подан на  вход " + e.getArrWidth() + 'x' + e.getArrHeight() + ".");
        } catch (MyArrayDataException e) {
            System.out.println("Значение элемента массива " + e.getWrongValue()/*testArray[e.getArrI()][e.getArrJ()]*/ + " с координатами [" + e.getArrI() + "]["+ e.getArrJ() + "]" + " не является числом.");
        }

    }

    public static void arrSquare(String[][] testArray) {
        int sum = 0;

        if (testArray != null) {

            for (int i = 0; i < testArray.length; i++) {
                for (int j = 0; j < testArray[i].length; j++) {
                    System.out.printf(testArray[i][j] + "   ");
                }
                System.out.println("\n");
            }

            if (testArray.length != 4 || testArray[0].length != 4) {
                throw new MyArraySizeException(testArray.length, testArray[0].length);
            }
        } else {
            throw new NullPointerException("Аргумент testArray метода arrSquare не может быть null");
        }

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(testArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, testArray[i][j]);
                }
            }
        }
        System.out.println("Сумма ячеек массива равна " + sum);

    }
}

