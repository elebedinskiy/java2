package ru.elebedinskiy.java2;

public interface Members extends Running, Jumping {
    String getName();
    void info();
    void setCountObstacles(int countObstacles);
    void setZeroCountOstacles();
    int getCountObstacles();
}
