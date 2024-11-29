package ru.innopolis.java.homework.homework10;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {12, 23, 34, 45, 56, 67, 78, 89};

        // Проверка на четность элемента
        ByCondition evenCondition = number -> number % 2 == 0;

        // Проверка, является ли сумма цифр элемента четным числом
        ByCondition sumOfDigitsEvenCondition = number -> {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };

        // Фильтрация массива по условию четности
        int[] evenNumbers = Sequence.filter(numbers, evenCondition);
        System.out.println("Четные числа: ");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Фильтрация массива по условию суммы цифр
        int[] sumOfDigitsEvenNumbers = Sequence.filter(numbers, sumOfDigitsEvenCondition);
        System.out.println("Числа, сумма цифр которых четное число: ");
        for (int num : sumOfDigitsEvenNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
