package ru.innopolis.java.Ilya_Smirnov.second_homework;

import java.util.Scanner;

public class whole_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Вs ввели не число, попробуйте еще раз");
        }
        int num1 = scanner.nextInt();
        System.out.println("Введите второе число: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Вs ввели не число, попробуйте еще раз");
        }
        int num2 = scanner.nextInt(); // 30 20: 125: 15,00 20 25 5
        System.out.println("Сумма двух целых чисел: " + (num1 + num2));
        if (num1 > num2) {
            System.out.println("Разница двух целых чисел: " + (num1 - num2));
        } else if (num2 > num1) {
            System.out.println("Разница двух целых чисел: " + (num2 - num1));
        } else {
            System.out.println("Разница двух целых чисел: 0");
        }
        System.out.println("Произведение из двух целых чисел: " + (num1 * num2));
        System.out.println("Среднее из двух целых чисел: " + ((num1 + num2) / 2));
        if ((num1 >= 0) && (num2 >= 0) && (num1 > num2)) {
            System.out.println("Расстояние двух целых чисел: " + (num1 - num2));
        }
        if ((num1 >= 0) && (num2 >= 0) && (num1 < num2)) {
            System.out.println("Расстояние двух целых чисел: " + (num2 - num1));
        }
        if ((num1 < 0) && (num2 >= 0) && (num1 < num2)) {
            System.out.println("Расстояние двух целых чисел: " + (num2 + (-num1)));
        }
        if (num1 > num2) {
            System.out.println("Максимальное целое число: " + num1);
            System.out.println("Минимальное целое число: " + num2);
        } else {
            System.out.println("Максимальное целое число: " + num2);
            System.out.println("Минимальное целое число: " + num1);
        }

    }
}
