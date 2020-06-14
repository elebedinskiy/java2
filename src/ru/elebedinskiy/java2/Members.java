package ru.elebedinskiy.java2;

public interface Members extends Running, Jumping {

    // участники умеют бегать и прыгать (интерфейс наследует Running, Jumping)
    String getName();
    void info();
    void setCountObstacles(int countObstacles);
    void setZeroCountOstacles();
    int getCountObstacles();
}
