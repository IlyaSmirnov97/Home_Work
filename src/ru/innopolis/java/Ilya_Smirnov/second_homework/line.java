package ru.innopolis.java.Ilya_Smirnov.second_homework;

import ru.innopolis.java.example1.Bulb;

import java.util.Arrays;
import java.util.Scanner;

public class line {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Сколько раз вывести строку? ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Вs ввели не число, попробуйте еще раз");
        }
        int num = scan.nextInt();
        String hi = "Java";
        System.out.print("После повторения " + num + " раз: ");
        for (int i = 0; i < num; i++) {

            System.out.print(hi);
        }

    }


}
