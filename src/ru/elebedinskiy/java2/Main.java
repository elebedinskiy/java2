package ru.elebedinskiy.java2;

import java.lang.reflect.Member;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // создали массив участников
        Members[] members = new Members[3];
        Running[] runners = new Running[members.length];
        Jumping[] jumpers = new Jumping[members.length];

        members[0] = new Cat("Барсик", 150, 2);
        //members[1] = new Cat("Мурзик", 55, 2.5f);
        //members[1] = new Robot("Девид");
        members[1] = new Cat("Муська", 45, 1.1f);
        //members[2] = new Cat("Муська", 45, 2.1f);
        members[2] = new Person("Василий", 200, 1.2f);

        // выведем информацию об участниках
        //runners[0].info();

        // создали массив препятствий
        Obstacles[] obstacles = new Obstacles[2];
        //obstacles[0] = createTreadmill("Олимпия-1", 100);
        obstacles[0] = new Treadmill("Олимпия-1", 100);
        //obstacles[1] = createWall("Кирпичная стена", 1.5f);

        //byte stages = 5; // количество этапов с препятствиями, например

        // вызов метода игры
        //gameStage(members, obstacles);
        members[0].info();
        members[2].info();

        if (members[0] instanceof Cat){
            ((Cat) members[0]).run(obstacles[0]);
        }
        //if (members[2] instanceof Person){
            //members[2].run(obstacles[0]);
          //  members[2].setCountObstacles(1);
        //}
        members[0].info();
        members[2].info();

    }

    // метод преодоления беговой дорожки
    public static void gameStage(Object[] members, Obstacles[] obstacles){
        //
    }

    // метод создаст нового кота, с произвольным ограничением на бег и прыжок
    public static Cat createCat(String name){
        float runMax;
        float jumpMax;
        Random random = new Random();
        do {
            runMax = random.nextFloat() * 1000;
        } while (runMax >= 50.0f && runMax <= 100.0f);
        do {
            jumpMax = random.nextFloat() * 1000;
        } while (jumpMax >= 1 && jumpMax <= 2.5f);
        Cat cat = new Cat(name, runMax, jumpMax);
        return cat;
    }

    /* метод создаст нового человека
    public static Person createPerson(String name){
        Person person = new Person(name);
        return person;
    }*/

    // метод создаст нового робота
    public static Robot createRobot(String name){
        Robot robot = new Robot(name);
        return robot;
    }

    // метод создаст новую беговую дорожку
    public static Treadmill createTreadmill(String name, float length){
        Treadmill treadmill = new Treadmill(name, length);
        return treadmill;
    }

    // метод создаст новую стену
    public static Wall createWall(String name, float height){
        Wall wall = new Wall(name, height);
        return wall;
    }

}
