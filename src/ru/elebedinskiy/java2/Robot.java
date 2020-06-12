package ru.elebedinskiy.java2;

public class Robot implements Members{
    private String name;
    private int countObstacles;
    private float runMax;
    private float jumpMax;

    Robot(String name, float runMax, float jumpMax){
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }

    public void setCountObstacles(int countObstacles){
        this.countObstacles = this.countObstacles + countObstacles;
    }

    public void setZeroCountOstacles() {
        this.countObstacles = 0;
    }

    public String getName() {
        return name;
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

    public void run(){
        System.out.println("Робот " + getName() + " пробежал");
    }

    public boolean run(Object object){
        if (object instanceof Treadmill){
            if (((Treadmill) object).getLength() <= getRunMax()){
                return true;
            } else if (((Treadmill) object).getLength() > getRunMax()){
                return false;
            }
        }
        return false;
    }

    public void jump(){
        System.out.println("Робот " + getName() + " прыгнул");
    }

    public boolean jump(Object object){
        if (object instanceof Wall){
            if (((Wall) object).getHeight() <= getJumpMax()){
                return true;
            } else if (((Wall) object).getHeight() > getJumpMax()){
                return false;
            }
        }
        return false;
    }

    public void info(){
        System.out.println(getName() + ", максимальная дистанция бега: " + getRunMax() + ", максимальная высота прыжка: " + getJumpMax());
    }
}
