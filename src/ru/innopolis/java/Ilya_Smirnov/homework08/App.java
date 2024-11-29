package ru.innopolis.java.Ilya_Smirnov.homework08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File("input.txt"))) {
            // Считывание количества покупателей
            int countPerson = fileScanner.nextInt();
            fileScanner.nextLine();

            // Считывание данных о покупателях
            for (int i = 0; i < countPerson; i++) {
                String namePerson = fileScanner.nextLine();
                int money = fileScanner.nextInt();
                fileScanner.nextLine(); // Пропуск новой строки
                Person person = new Person(namePerson, money);
                personList.add(person);
            }

            // Считывание количества товаров
            int countProduct = fileScanner.nextInt();
            fileScanner.nextLine(); // Пропуск новой строки

            // Считывание данных о товарах
            for (int i = 0; i < countProduct; i++) {
                String nameProduct = fileScanner.nextLine();
                int price = fileScanner.nextInt();
                fileScanner.nextLine(); // Пропуск новой строки
                Product product = new Product(nameProduct, price);
                productList.add(product);
            }

            // Обработка покупок
            try (PrintWriter writer = new PrintWriter(new File("output.txt"))) {
                while (true) {
                    int personIndex = fileScanner.nextInt();
                    if (personIndex < 1) break;
                    int productIndex = fileScanner.nextInt();
                    if (productIndex < 1) break;

                    Person person = personList.get(personIndex - 1);
                    Product product = productList.get(productIndex - 1);

                    if (person.checkPriceAndMoney(product.getPrice())) {
                        person.addProductPacket(product);
                        writer.println(person.getName() + " купил " + product.getProductName());
                    } else {
                        writer.println(person.getName() + " не может позволить себе " + product.getProductName());
                    }
                }

                // Запись итогов
                for (Person person : personList) {
                    writer.println(person);
                    System.out.println(person);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

}