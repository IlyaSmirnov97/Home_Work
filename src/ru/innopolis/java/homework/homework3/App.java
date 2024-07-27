package ru.innopolis.java.homework.homework3;

import java.util.Scanner;

public class App {
    public static String getModelName (int m){
        if (m == 1) {
            return  ("Samsung");
        } else if (m == 2) {
            return ("LG");
        } else {
            return ("Haier");
        }
    }
    public static String getDiagonalSize (int d){
        if (d == 1) {
            return ("32см");
        } else if (d == 2) {
            return ("55см");
        } else {
            return("61см");
        }

    }

    public static void main(String[] args) {
        Tv tv = new Tv();
        System.out.println("Выбирите бренд телевизора\n1-Samsung\n2-LG\n3-Haier");
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        tv.setModel(getModelName(m));
        System.out.println("Выбирите диогональ телевизора\n1-32см\n2-55см\n3-61см");
        int d = scan.nextInt();
        tv.setDiagonal(getDiagonalSize(d));
        System.out.println("Выбрал пользователь: " + tv);

        Tv tv2 = new Tv();
        int m2 = (int) (Math.random() * 3);
        tv2.setModel(getModelName(m2));
        int d2 = (int) (Math.random() * 3);
        tv2.setDiagonal(getDiagonalSize(d2));
        System.out.println("Выбрала система: " + tv2);

        Tv tv3 = new Tv("Siemens","78");
        System.out.println("Выбрал я: " + tv3);


    }

}
