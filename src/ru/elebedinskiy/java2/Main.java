package ru.elebedinskiy.java2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /* Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
	    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
	    Посчитать сколько раз встречается каждое слово. */

        ArrayList<String> words = new ArrayList<>(Arrays.asList(
                "Один", "Два", "Три", "Четыре", "Один", "Два", "Три",
                "Пять", "Один", "Два", "Три", "Четыре", "Четыре", "Пять",
                "Один", "Два", "Три", "Пять", "Четыре", "Три"));

        System.out.print("Коллекция из " + words.size() + " слов:");
        System.out.println(words);

        removeDuplicatesFromList(words);

    }

    // метод вывода уникальных записей в коллекции List
    public static void removeDuplicatesFromList (ArrayList<String> list){
        int[] index = new int[list.size()]; // тут будем хранить индексы дублей
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i).equals(list.get(j))){
                    index[i] = index[i] + 1;
                }
            }
        // удалим дублирующиеся элементы коллекции согласно найденным индексам
        for (int i = index.length - 1; i>=0; i--){
            if (index[i] != 0){
                index[i] = index[i] + 1;
                list.remove(i);
            }
        }
        printList(list, index);
    }

    //метод вывода в консоль
    public static void printList(ArrayList<String> list, int[] index){
        System.out.println("\nУникальных слов: " + list.size() + " ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Слово '" + list.get(i) + "' встретилось " + index[i] + " раз(-а)");
        }
    }
}
