package ru.elebedinskiy.java2;

public class Main {

    public static void main(String[] args) {

        // создание объектов классов
        Person person1 = new Person("Василий");
        Person person2 = new Person("Иннокентий");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Robot robot1 = new Robot("Бишоп");
        Robot robot2 = new Robot("Дэвид");

        // бегаем и прыгаем
        person1.run();
        person2.jump();
        cat1.run();
        cat2.jump();
        robot1.run();
        robot2.jump();

    }

}
