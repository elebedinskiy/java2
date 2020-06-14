package ru.elebedinskiy.java2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] array1 = {
                {"18","#1","18","54"},
                {"28","45","90","54"},
                {"45","3","symbol","54"},
                {"text","3","14","54"}
        };
        String[][] array2 = {
                {"18","#1","18"},
                {"28","45","90"},
                {"28","45","90"},
                {"45","3","symbol"},
                {"text","3","14"}
        };
        String[][] array3 = {
                {"18","#1","18","hi","33"},
                {"28","45","90","54","33"},
                {"28","45","90","54","test"},
                {"45","3","symbol","54","33"},
                {"text","3","14","54","33"}
        };

        System.out.println("Исходный массив #1: " + Arrays.deepToString(array1));
        System.out.println("Исходный массив #2: " + Arrays.deepToString(array2));

        System.out.println("\nРаботаем с первым массивом");
        procArray(array1,4);
        System.out.println("\nРаботаем со вторым массивом");
        procArray(array2,4);
        System.out.println("\nРаботаем с третим массивом");
        procArray(array3,4);
    }

    // метод валидации массива
    public static boolean validArray(String[][] array, int size) {
        String[][] validArray = new String[size][size];
        try {
            for (int i = 0; i < size; i++) {
                if (array.length != size || array[i].length != size) { // размер столбцов не равен size и размер конкретной строки не равен size
                    for (int j = size - 1; j <= size; j++) { // попробуем обратиться к элементу до и после size
                        validArray[i][j] = array[i][j];
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    // метод обработки массива
    public static void procArray(String[][] array, int size) {
        if (validArray(array, size) == false){
            System.out.println("Ошибка! Массив не соответствует размеру " + size + " х " + size + "!");
        } else if (validArray(array, size) == true){
            System.out.println("Массив размера " + size + " х " + size + ", работаем дальше...");
            // тут пишем обработку
        }
    }

}
