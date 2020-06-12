package ru.elebedinskiy.java2;

public class Treadmill implements Obstacles{
    private String name;
    private float length;

    Treadmill(String name, float length){
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return name;
    }

    public float getLength(){
        return length;
    }

    public void info(){
        System.out.println("Беговая дорожка " + getName() + ", дистанция: " + getLength());
    }

}