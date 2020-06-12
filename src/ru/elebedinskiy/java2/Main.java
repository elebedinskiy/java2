package ru.elebedinskiy.java2;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        // создали массив участников
        Members[] members = new Members[3];

        members[0] = new Cat("кот Барсик", 55, 1.3f);
        members[1] = new Person("человек Василий", 1000, 2);
        members[2] = new Robot("робот Бишоп", 25000, 5);

        // создали массив препятствий
        Obstacles[] obstacles = new Obstacles[4];
        obstacles[0] = new Treadmill("Беговая дорожка Олимпия-1", 50);
        obstacles[1] = new Wall("Кирпичная стена", 1.5f);
        obstacles[2] = new Wall("Бетонная стена", 3);
        obstacles[3] = new Treadmill("Тропинка в городском парке", 1500);

        System.out.println("Приветствуем участников !");
        printInfo(members); // выведем информацию об участниках

        System.out.println("\nИм предстоит преодолеть следующие препятствия:");
        printInfo(obstacles); // выведем информацию о препятствиях

        System.out.println(); // начнём игру с новой строки
        System.out.println("Поехали! ...");
        game(members, obstacles); // проходим препятствия

    }

    // метод преодоления участниками препятствий с учётом ограничений участников и схода с дистанции
    public static void game(Members[] members, Obstacles[] obstacles) {

        // обнулим счетчик преодоленных препятствий
        setZeroCountObstacles(members);

        for (int i = 0; i < members.length; i++){
            for (int j = 0; j < obstacles.length; j++){
                if (obstacles[j] instanceof Treadmill) {
                    if (members[i].run(obstacles[j]) == true) {
                        System.out.println(members[i].getName() + " пробежал препятствие #" + (j + 1) + " " + obstacles[j].getName());
                        members[i].setCountObstacles(1);
                    } else if (members[i].run(obstacles[j]) == false){
                        System.out.println(members[i].getName() + " не смог пробежать препятствие #" + (j + 1) + " " + obstacles[j].getName() + ", сходит с дистанции и покидает нас.");
                        break;
                    }
                }
                if (obstacles[j] instanceof Wall) {
                    if (members[i].jump(obstacles[j]) == true) {
                        System.out.println(members[i].getName() + " перепрыгнул препятствие #" + (j + 1) + " " + obstacles[j].getName());
                        members[i].setCountObstacles(1);
                    } else if (members[i].jump(obstacles[j]) == false){
                        System.out.println(members[i].getName() + " не смог перепрыгнуть препятствие #" + (j + 1) + " " + obstacles[j].getName() + ", сходит с дистанции и покидает нас.");
                        break;
                    }
                }
            }
        }
        System.out.println();
        printRezults(members);
        winner(members);
    }

    // метод подсчёта итогов
    public static void printRezults(Members[] members){
        System.out.println("Подведём итоги:");
        for (int i = 0; i < members.length; i++){
            System.out.println(members[i].getName() + " преодолел " + members[i].getCountObstacles() + " препятствий");
        }
    }

    // метод определения победителя
    public static void winner(Members[] members) {
        int i = 0;
        int winnerId = members.length - 1 - i; // допустим, что последний элемент - победитель
        do {
            if (members[i].getCountObstacles() > members[winnerId].getCountObstacles()){
                winnerId = i; // определим победителя
            }
            i++;
        }while (i < members.length);
        System.out.println(members[winnerId].getName() + " - победитель! Ура!");
    }

    // метод обнулит счётчик пройденных препятствий участников
    public static void setZeroCountObstacles(Members[] members){
        for (int i = 0; i < members.length; i++){
            members[i].setZeroCountOstacles();
        }
    }

    // метод выведет в консоль информацию об участниках или препятствиях
    public static void printInfo(Object[] object){
        for (int i = 0; i < object.length; i++){
            if (object[i] instanceof Obstacles){
                System.out.print("#" + (i + 1) + " ");
                ((Obstacles) object[i]).info();
            }
            if (object[i] instanceof Members){
                System.out.print("#" + (i + 1) + " ");
                ((Members) object[i]).info();
            }
        }
    }

}
