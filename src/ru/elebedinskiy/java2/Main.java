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
                {"28","45","90","54"},
                {"28","45","90","54","test"},
                {"45","3","symbol","54"},
                {"text","3","14","54"}
        };

        System.out.println("Исходный массив #1: " + Arrays.deepToString(array1));
        System.out.println("Исходный массив #2: " + Arrays.deepToString(array2));

        System.out.println("\nПервый массив");
        //procArray(array1,4);
        System.out.println("\nВторой массив");
        //procArray(array2,4);
    }
}
