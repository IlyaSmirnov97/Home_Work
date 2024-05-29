package ru.innopolis.java.first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        int start = 1;
        int end = 5;

        for (int i = start; i <= end; i++) {
            System.out.println("Hello, world! Hello, " + name);
        }
    }
}
