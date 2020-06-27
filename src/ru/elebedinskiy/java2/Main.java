package ru.elebedinskiy.java2;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        float[] array1 = new float[SIZE];
        float[] array2 = new float[SIZE];

        procArray0to1(array1);
        procArray0to1(array2);

        procArray1thread(array1);
        procArray2thread(array2);

    }

    public static void procArray0to1 (float[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = 1;
        }
    }

    public static void procArray1thread (float[] array){
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++){
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("time 1: " + (end - start));
    }

    public static void procArray2thread (float[] array){

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        long start = System.currentTimeMillis();

        // разделим массив на два массива одинаковой длинны
        System.arraycopy(array, 0, arr1, 0, HALF);
        System.arraycopy(array, HALF, arr2, 0, HALF);

        // проведем вычисления в двух разных потоках
        new Thread(() -> new NewThread().procArrayInNewThread(arr1)).start();
        new Thread(() -> new NewThread().procArrayInNewThread(arr2)).start();

        // склеим массив обратно в один целый
        System.arraycopy(arr1, 0, array, 0, HALF);
        System.arraycopy(arr2, 0, array, HALF, HALF);

        long end = System.currentTimeMillis();
        System.out.println("time 2: " + (end - start));

    }

}
