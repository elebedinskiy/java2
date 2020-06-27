package ru.elebedinskiy.java2;

public class NewThread extends Thread {

    @Override
    public void run(){

    }

    public void procArrayInNewThread (float[] array) {
        //System.out.println("Thread name: " + Thread.currentThread().getName()); // для проверки
        for (int i = 0; i < array.length; i++){
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}