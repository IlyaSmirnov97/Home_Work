package ru.innopolis.java.homework.homework10;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        // Считаем, сколько элементов удовлетворяют условию
        int count = 0;
        for (int number : array) {
            if (condition.isOk(number)) {
                count++;
            }
        }


        int[] result = new int[count];
        int index = 0;
        for (int number : array) {
            if (condition.isOk(number)) {
                result[index++] = number;
            }
        }

        return result;
    }
}

