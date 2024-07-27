package ru.innopolis.java.homework.homework4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String left = "<--<<";
        String right = ">>-->";
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        String str = scanner.nextLine();
        for (int i = 0; i < str.length() - 4; i++) {

            if (str.substring(i, i + 5).equals(left) || str.substring(i, i + 5).equals(right) ){
                row++;
            }
        }
        System.out.println("Количество стрел: " + (row));
    }
}

//Вводимые данные >>-->>--><--<<--<<-->>-->><<--<<----<<<>>>>-->>
