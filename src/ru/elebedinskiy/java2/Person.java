package ru.elebedinskiy.java2;

public class Person {
    private String name;

    Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void run(){
        System.out.println("Человек " + getName() + " пробежал");
    }

    public void jump(){
        System.out.println("Человек " + getName() + " прыгнул");
    }
}
