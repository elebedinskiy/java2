package ru.elebedinskiy.java2;

public class Person implements Members{
    private String name;
    private int countObstacles;
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

    public boolean run(){
        System.out.println("Человек " + getName() + " пробежал");
        return true;
    }

    public boolean run(Object object){
        if (object instanceof Treadmill){
            if (((Treadmill) object).getLength() <= getRunMax()){
                System.out.println("Человек " + getName() + " пробежал препятствие");
                return true;
            } else if (((Treadmill) object).getLength() > getRunMax()){
                System.out.println("Человек " + getName() + " не смог пробежать препятствие");
                return false;
            }
        }
        return false;
    }

    public boolean jump(){
        System.out.println("Человек " + getName() + " прыгнул");
        return true;
    }

    public boolean jump(Object object){
        if (object instanceof Wall){
            if (((Wall) object).getHeight() <= getJumpMax()){
                System.out.println("Человек " + getName() + " перепрыгнул препятствие");
                return true;
            } else if (((Wall) object).getHeight() > getJumpMax()){
                System.out.println("Человек " + getName() + " не смог перепрыгнуть препятствие");
                return false;
            }
        }
        return false;
    }

    public void setCountObstacles(int countObstacles){
        this.countObstacles = this.countObstacles + countObstacles;
    }

    public void info(){
        System.out.println("Человек по имени " + getName() + ", максимальная дистанция бега: " + getRunMax() + ", максимальная высота прыжка: " + getJumpMax() + ", пройденных препятствий: " + getCountObstacles());
    }
}
