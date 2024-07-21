package ru.innopolis.java.homework.homework1;

import java.util.Scanner;

public class Spaces {
    public static void main(String[] args) {
        Scanner Spaces = new Scanner(System.in);
        System.out.println("Введите первое число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("ВЫ ввели не число, попробуйте еще раз");
        }
        int num1 = Spaces.nextInt();
        System.out.println("Введите второе число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("Вы ввели не число, попробуйте еще раз");
        }
        int num2 = Spaces.nextInt();
        System.out.println("Введите третье число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("ВЫ ввели не число, попробуйте еще раз");
        }
        int num3 = Spaces.nextInt();
        System.out.println("Введите четвертое число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("ВЫ ввели не число, попробуйте еще раз");
        }
        int num4 = Spaces.nextInt();
        System.out.println(String.format("%d   %d   %d   %d", num1, num2, num3, num4));
        Spaces.close();
    }
}
