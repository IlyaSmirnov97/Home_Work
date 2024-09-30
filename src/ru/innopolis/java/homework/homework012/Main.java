package ru.innopolis.java.homework.homework012;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные ([Фамилия Имя Отчество] датарождения номертелефона(10 цифр, номер вводится без 8) пол возраст) в произвольном порядке:");
        String input = scanner.nextLine();

        try {
            Person person = parseInput(input);
            savePersonToFile(person);
            System.out.println("Данные успешно сохранены: " + person);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static Person parseInput(String input) {
        String[] data = input.trim().split("\\s+"); // Разделяем по пробелам

        if (data.length < 7) {
            throw new IllegalArgumentException("Ошибка: недостаточно данных.");
        }

        String surname = null;
        String name = null;
        String patronymic = null;
        String birthDate = null;
        Long phoneNumber = null;
        Character gender = null;
        Integer age = null;

        for (String field : data) {
            if (surname == null && field.matches("[а-яА-ЯёЁa-zA-Z]+")) {
                surname = field;
            } else if (name == null && field.matches("[а-яА-ЯёЁa-zA-Z]+")) {
                name = field;
            } else if (patronymic == null && field.matches("[а-яА-ЯёЁa-zA-Z]+")) {
                patronymic = field;
            } else if (birthDate == null && field.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                birthDate = field;
            } else if (phoneNumber == null && field.matches("\\d{10}")) {
                phoneNumber = Long.parseLong(field);
            } else if (gender == null && (field.equals("m") || field.equals("f"))) {
                gender = field.charAt(0);
            } else if (age == null && field.matches("\\d+")) {
                age = Integer.parseInt(field);
            }
        }

        if (surname == null) throw new IllegalArgumentException("Ошибка: фамилия не указана.");
        if (name == null) throw new IllegalArgumentException("Ошибка: имя не указано.");
        if (patronymic == null) throw new IllegalArgumentException("Ошибка: отчество не указано.");
        if (birthDate == null) throw new IllegalArgumentException("Ошибка: дата рождения не указана.");
        if (phoneNumber == null) throw new IllegalArgumentException("Ошибка: номер телефона не указан.");
        if (gender == null) throw new IllegalArgumentException("Ошибка: пол не указан.");
        if (age == null || age <= 0) throw new IllegalArgumentException("Ошибка: возраст не указан или неверен.");

        return new Person(surname, name, patronymic, birthDate, phoneNumber, gender, age);
    }

    private static void savePersonToFile(Person person) throws IOException {
        // Указываем путь к файлу с использованием нужного вам пути
        String filePath = "C:\\Users\\ilyas\\Учеба\\Home_Work2\\src\\ru\\innopolis\\java\\homework\\homework012\\" + person.getSurname() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(person.toString());
            writer.newLine();
        }
    }

}





