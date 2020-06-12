package ru.elebedinskiy.java2;

public class Main {

    public static void main(String[] args) {

        // создали массив участников
        Members[] members = new Members[4];

        members[0] = new Cat("Барсик", 55, 1.3f);
        members[1] = new Cat("Муська", 45, 2.5f);
        members[2] = new Person("Василий", 21100, 2);
        members[3] = new Person("Алиса", 5000, 1.2f);
        //members[4] = new Robot("Бишоп");
        //members[5] = new Robot("R2D2");

        // создали массив препятствий
        Obstacles[] obstacles = new Obstacles[2];
        obstacles[0] = new Treadmill("Олимпия-1", 50);
        obstacles[1] = new Wall("Кирпичная", 1.5f);

        printInfo(members); // выведем информацию об участниках
        printInfo(obstacles); // выведем информацию о препятствиях

        System.out.println(); // с новой строки

        game(members, obstacles, 1); // проходим круги препятствий

        System.out.println(); // с новой строки
        printInfo(members);

    }

    public static void game (Members[] members, Obstacles[] obstacles, int stage){
        setZeroCountObstacles(members);
        for (int i = 0; i < stage; i++){
            System.out.println("Круг №: " + (i + 1));
            for (int a = 0; a < obstacles.length; a++){
                for (int j = 0; j < members.length; j++){
                    if (obstacles[a] instanceof Treadmill){
                        members[j].run(obstacles[a]);
                        if (members[j].run(obstacles[a]) == true){
                            members[j].setCountObstacles(1);
                        }
                    }
                    if (obstacles[a] instanceof Wall){
                        members[j].jump(obstacles[a]);
                        if (members[j].jump(obstacles[a]) == true){
                            members[j].setCountObstacles(1);
                        }
                    }
                }
            }
            System.out.println();
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
