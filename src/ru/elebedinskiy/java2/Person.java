package ru.elebedinskiy.java2;

public class Person implements Members{
    private String name;
    private int countObstacles = 0;
    private float runMax;
    private float jumpMax;

    Person(String name, float runMax, float jumpMax){
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }

    public float getRunMax() {
        return runMax;
    }

    public float getJumpMax() {
        return jumpMax;
    }

    public int getCountObstacles() {
        return countObstacles;
    }

    public void setZeroCountOstacles() {
        this.countObstacles = 0;
    }

    public String getName(){
        return name;
    }

    public void run(){
        System.out.println("Человек " + getName() + " пробежал");
    }

    public void run(Object obstacles){
        if (obstacles instanceof Treadmill){
            if (((Treadmill) obstacles).getLength() <= getRunMax()){
                System.out.println("Человек " + getName() + " бегом преодолел препятствие");
                setCountObstacles(1);
            }
        }
    }

    public void jump(){
        System.out.println("Человек " + getName() + " прыгнул");
    }

    public void setCountObstacles(int countObstacles){
        this.countObstacles = this.countObstacles + countObstacles;
    }

    public void info(){
        System.out.println("Человек по имени " + getName() + ", максимальная дистанция бега: " + getRunMax() + ", максимальная высота прыжка: " + getJumpMax() + ", пройденных препятствий: " + getCountObstacles());
    }
}
