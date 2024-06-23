package ru.innopolis.java.Ilya_Smirnov.fourth_homework;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws Exception {

        // Алфавит
        String abc = "qwertyuiopasdfghjklzxcvbnm";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }
        Scanner scanner = new Scanner(System.in);
        char bukva = scanner.next().charAt(0);
        for (int i = 0;i<abcArray.length; i++) {
            if ( bukva == abcArray[i]){
                if (i == 0){
                    System.out.println("Ответ: " + (abcArray[abcArray.length - 1]));
                } else {
                    System.out.println("Ответ: " + (abcArray[i - 1]));
                }
            }
        }
    }
}
