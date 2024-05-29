package ru.innopolis.java.Ilya_Smirnov.first_homework;

import java.util.Scanner;

public class Spaces {
    public static void main(String[] args) {
        Scanner Spaces = new Scanner(System.in);
        System.out.println("Введите первое число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("Введите ввели не число, попробуйте еще раз");
        }
        int num1 = Spaces.nextInt();
        System.out.println("Введите второе число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("Введите ввели не число, попробуйте еще раз");
        }
        int num2 = Spaces.nextInt();
        System.out.println("Введите третье число:");
        while (!Spaces.hasNextInt()) {
            Spaces.next();
            System.out.println("Введите ввели не число, попробуйте еще раз");
        }
        int num3 = Spaces.nextInt();
        System.out.println(num1 + "   " + num2 + "   " + num3);
        Spaces.close();
    }
}
