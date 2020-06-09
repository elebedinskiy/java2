package ru.elebedinskiy.java2;

public class Cat {
    private String name;

    Cat(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void run(){
        System.out.println("Кот " + getName() + " пробежал");
    }

    public void jump(){
        System.out.println("Кот " + getName() + " прыгнул");
    }
}
