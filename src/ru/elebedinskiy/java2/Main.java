package ru.elebedinskiy.java2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // массив размером 4 на 4
        String[][] array1 = {
                {"18","#1","18","54"},
                {"28","45","90","54"},
                {"45","3","symbol","54"},
                {"text","3","14","54"}
        };
        // массив размером 5 на 4
        String[][] array2 = {
                {"18","#1","18"},
                {"28","45","90"},
                {"28","45","90"},
                {"45","3","symbol"},
                {"text","3","14"}
        };
        // массив размеров 4 на 5
        String[][] array3 = {
                {"18","#1","18","hi","33"},
                {"28","45","90","54","33"},
                {"28","45","90","54","test"},
                {"45","3","symbol","54","33"},
        };

        System.out.println("Исходный массив #1: " + Arrays.deepToString(array1));
        System.out.println("Исходный массив #2: " + Arrays.deepToString(array2));
        System.out.println("Исходный массив #3: " + Arrays.deepToString(array3));

        int size = 4; // размерность двумерного массива, с которой будем работать

        System.out.println("\nРаботаем с первым массивом");
        procArray(array1,size);
        System.out.println("\nРаботаем со вторым массивом");
        procArray(array2,size);
        System.out.println("\nРаботаем с третьим массивом");
        procArray(array3,size);

    }

    // метод валидации двумерного массива
    public static boolean MyArraySizeException(String[][] array, int size) {
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

    // метод обработки двумерного массива
    public static void procArray(String[][] array, int size) {
        if (MyArraySizeException(array, size) == false){
            System.out.println("Ошибка! Массив не соответствует размеру " + size + " х " + size + "!");
        } else if (MyArraySizeException(array, size) == true){
            System.out.println("Массив размера " + size + " х " + size + ", работаем дальше...");
            System.out.println("Обработанный массив: " + Arrays.deepToString(MyArrayDataException(array)));
        }
    }

    private static int[][] sumProcArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]++;
            }
        }
        return array;
    }

    // метод работы с целочисленными значениями элементов двумерного массива
    public static int[][] MyArrayDataException (String[][] array){
        int[][] procArray = new int[array.length][array.length]; // так как строка - неизменяемый тип данных, создадим новый массив
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try {
                    int a = Integer.parseInt(array[i][j].trim()); // приведём строку к целочисленному
                    a++; // просуммируем
                    procArray[i][j] = a;
                } catch (NumberFormatException e){
                    System.out.println("Ошибка! Элемент " + i + " х " + j + " не может быть обработан, так как содержит строку или символ");
                }
            }
        }
        return procArray;
    }
}
