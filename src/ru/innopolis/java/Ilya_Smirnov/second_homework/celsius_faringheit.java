package ru.innopolis.java.Ilya_Smirnov.second_homework;

import java.util.Scanner;

public class celsius_faringheit {
    public static void main(String[] args) {
        Scanner fr = new Scanner(System.in);
        System.out.println("Введите градусы в фарингейтах: ");
        while (!fr.hasNextInt()) {
            fr.next();
            System.out.println("Вs ввели не число, попробуйте еще раз");
        }
        double farenheit = fr.nextDouble();
        double celsius = (farenheit - 32) * 5 / 9;
        System.out.printf(farenheit + " градусов по Фаренгейту равна " + celsius + " по Цельсию");
        //212.0 градусов по Фаренгейту равна 100.0 по Цельсию
    }
}
