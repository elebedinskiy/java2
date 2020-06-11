package ru.elebedinskiy.java2;

public class Cat implements Members{
    private String name;
    private int countObstacles = 0;
    private float runMax;
    private float jumpMax;

    Cat(String name, float runMax, float jumpMax){
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
        System.out.println("Кот " + getName() + " пробежал препятствие");
    }

    public void run(Object obstacles){
        if (obstacles instanceof Treadmill){
            if (((Treadmill) obstacles).getLength() <= getRunMax()){
                System.out.println("Кот " + getName() + " пробежал препятствие");
                setCountObstacles(1);
            }
        }
    }

    public void jump(){
        System.out.println("Кот " + getName() + " перепрыгнул препятствие");
    }

    public void jump(Object object){
        if (object instanceof Wall){
            if (((Wall) object).getHeight() <= getJumpMax()){
                System.out.println("Кот " + getName() + " перепрыгнул препятствие");
                setCountObstacles(1);
            }
        }
    }

    public void info(){
        System.out.println("Кот по имени " + getName() + ", максимальная дистанция бега: " + getRunMax() + ", максимальная высота прыжка: " + getJumpMax() + ", пройденных препятствий: " + getCountObstacles());
    }
}
