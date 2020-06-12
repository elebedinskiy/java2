package ru.elebedinskiy.java2;

public class Main {

    public static void main(String[] args) {

        // создали массив участников
        Members[] members = new Members[2];

        members[0] = new Cat("Барсик", 55, 1.3f);
        //members[1] = new Cat("Муська", 45, 2.5f);
        members[1] = new Person("Василий", 1000, 2);
        //members[3] = new Person("Алиса", 5000, 1.2f);
        //members[4] = new Robot("Бишоп");
        //members[5] = new Robot("R2D2");

        // создали массив препятствий
        Obstacles[] obstacles = new Obstacles[4];
        obstacles[0] = new Treadmill("Беговая дорожка Олимпия-1", 50);
        obstacles[1] = new Wall("Кирпичная стена", 1.5f);
        obstacles[2] = new Wall("Бетонная стена", 3);
        obstacles[3] = new Treadmill("Тропинка в городском парке", 1500);

        printInfo(members); // выведем информацию об участниках
        printInfo(obstacles); // выведем информацию о препятствиях

        System.out.println(); // начнём игру с новой строки

        game(members, obstacles); // проходим препятствия
        printInfo(members);

    }

    public static void game(Members[] members, Obstacles[] obstacles) {
        setZeroCountObstacles(members);
        for (int i = 0; i < obstacles.length; i++) {
            System.out.print("Препятствие № " + (i + 1) + ", ");
            obstacles[i].info();
            for (int j = 0; j < members.length; j++) {
                if (obstacles[i] instanceof Treadmill) {
                    if (members[j].run(obstacles[i]) == true) {
                        members[j].setCountObstacles(1);
                    }
                }
                if (obstacles[i] instanceof Wall) {
                    if (members[j].jump(obstacles[i]) == true) {
                        members[j].setCountObstacles(1);
                    }
                }
            }
            System.out.println();
            // сюда нужно добавить обработку: идёт дальше участник или не идёт
        }
    }

    // метод обнулит счётчик пройденных препятствий участников
    public static void setZeroCountObstacles(Members[] members){
        for (int i = 0; i < members.length; i++){
            members[i].setZeroCountOstacles();
        }
    }

    public static void printInfo(Object[] object){
        for (int i = 0; i < object.length; i++){
            if (object[i] instanceof Obstacles){
                ((Obstacles) object[i]).info();
            }
            if (object[i] instanceof Members){
                ((Members) object[i]).info();
            }
        }
    }

}
