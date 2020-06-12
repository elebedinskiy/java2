package ru.elebedinskiy.java2;

public class Wall  implements Obstacles{
    private String name;
    private float height;

    Wall(String name, float height){
        this.name = name;
        this.height = height;
    }

    public String getName(){
        return name;
    }

    public float getHeight(){
        return height;
    }

    public void info(){
        System.out.println("Стена " + getName() + ", высота: " + getHeight());
    }

}