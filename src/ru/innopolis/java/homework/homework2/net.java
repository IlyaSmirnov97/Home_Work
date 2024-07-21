package ru.innopolis.java.homework.homework2;

import java.util.Scanner;

public class net {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число строк и столбцов сетки: ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Вs ввели не число, попробуйте еще раз");
        }
        int num = scan.nextInt();
        System.out.println("Введите повторяемый элемент сетки: ");
        String el = scan.next();

        for (int i = 0; i < num; i++) {
            for (int b = 0; b < num; b++) {
                System.out.print(el);
            }
            System.out.println();
        }
    }
}
