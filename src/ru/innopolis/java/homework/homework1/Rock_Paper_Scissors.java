package ru.innopolis.java.homework.homework1;


public class Rock_Paper_Scissors {
    public static void main(String[] args) {
        int petya = (int) (Math.random() * 3);
        int vasya = (int) (Math.random() * 3);
        if (petya == 0) {
            System.out.println("У Пети камень");
        } else if (petya == 1) {
            System.out.println("У Пети ножницы");
        } else if (petya == 2) {
            System.out.println("У Пети бумага");
        }
        if (vasya == 0) {
            System.out.println("У Васи камень");
        } else if (vasya == 1) {
            System.out.println("У Васи ножницы");
        } else if (vasya == 2) {
            System.out.println("У Васи бумага");
        }

        if (petya == 0) {
            if (vasya == 0) {
                System.out.println("Ничья");
            } else if (vasya == 1) {
                System.out.println("Выиграл Петя");
            } else if (vasya == 2) {
                System.out.println("Выиграл Вася");
            }
        } else if (petya == 1) {
            if (vasya == 0) {
                System.out.println("Выиграл Вася");
            } else if (vasya == 1) {
                System.out.println("Ничья");
            } else if (vasya == 2) {
                System.out.println("Выиграл Петя");
            }
        } else if (petya == 2) {
            if (vasya == 0) {
                System.out.println("Выиграл Петя");
            } else if (vasya == 1) {
                System.out.println("Выиграл Вася");
            } else if (vasya == 2) {
                System.out.println("Ничья");
            }
        }
    }
}
