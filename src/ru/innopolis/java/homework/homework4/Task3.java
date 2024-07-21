package ru.innopolis.java.homework.homework4;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toLowerCase().toCharArray();
            Arrays.sort(word);
            words[i] = new String(word);

        }
        System.out.print("Ответ:");
        for (String word : words) {
            System.out.print(" " + word);
        }
    }
}
