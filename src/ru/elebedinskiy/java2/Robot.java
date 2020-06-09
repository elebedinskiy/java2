package ru.elebedinskiy.java2;

public class Robot {
    private String name;

    Robot(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void run(){
        System.out.println("Робот " + getName() + " пробежал");
    }

    public void jump(){
        System.out.println("Робот " + getName() + " прыгнул");
    }
}
