package ru.elebedinskiy.java2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr1 = new float[SIZE];
        float[] arr2 = new float[SIZE];
        float[] arr21 = new float[HALF];
        float[] arr22 = new float[HALF];

        // ЭТО БУДЕТ МЕТОД 1
        // заполним оба массива единицами
        for (int i = 0; i < arr1.length; i++){
            arr1[i] = 1;
            arr2[i] = 1;
        }

        // ЭТО БУДЕТ МЕТОД 2
        // проведем вычисления с замером времени в одном потоке
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++){
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end1 = System.currentTimeMillis();
        System.out.println("time 1: " + (end1 - start1));
        // end


        // ЭТО БУДЕТ МЕТОД 3
        long start2 = System.currentTimeMillis();
        // разделим массива на два массива одинаковой длинны
        System.arraycopy(arr2, 0, arr21, 0, HALF);
        System.arraycopy(arr2, HALF, arr22, 0, HALF);

        // проведём исчисления в разных потоках;

        // склеим массив обратно в один целый
        System.arraycopy(arr21, 0, arr2, 0, HALF);
        System.arraycopy(arr22, 0, arr2, HALF, HALF);
        long end2 = System.currentTimeMillis();
        System.out.println("time 2: " + (end2 - start2));

    }
}
