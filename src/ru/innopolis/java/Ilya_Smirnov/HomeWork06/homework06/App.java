package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework06;

import java.util.*;

public class App {
    public static void main(String[] args) {

        /*Павел Андреевич   =   10000;
        Анна Петровна = 2000;
        Борис = 10;
        Женя = 0;

        Хлеб = 40;
        Молоко = 60;
        Торт = 1000;
        Кофе растворимый = 879;
        Масло = 150;
        Мороженое = 200;

        Павел Андреевич Хлеб
        Павел Андреевич  Масло
        Анна Петровна  Кофе растворимый
        Анна Петровна   Молоко
        Анна Петровна   Молоко
        Анна Петровна   Молоко
        Анна Петровна  Торт
        Борис Торт
        Павел Андреевич  Торт
        Женя Мороженое*/


        //Создаем массивы клиентов и продуктов
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();


        //Добавляем пользователей
        System.out.println("Сколько будет покупателей?");
        Scanner scanner = new Scanner(System.in);
        int countPerson = scanner.nextInt();

        for (int i = 0; i < countPerson; i++) {

            System.out.println("Введите имя для пользователя " + (i + 1));
            scanner.nextLine();
            String namePerson = scanner.nextLine();
            System.out.println("Введите баланс пользователя для " + namePerson);
            int money = scanner.nextInt();
            Person person = new Person(namePerson, money);
            personList.add(person);
        }

        //Добавляем товары
        System.out.println("Сколько будет Товаров?");
        int countProduct = scanner.nextInt();

        for (int i = 0; i < countProduct; i++) {

            System.out.println("Введите название для товара " + (i + 1));
            scanner.nextLine();
            String nameProduct = scanner.nextLine();
            System.out.println("Введите цену товара для " + nameProduct);
            int money = scanner.nextInt();
            Product product = new Product(nameProduct, money);
            productList.add(product);
        }

        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i + 1) + " - " + personList.get(i).getName());
        }
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + " - " + productList.get(i));
        }

        while (true) {
            System.out.println("Для завершения операции введите число меньше 1");
            System.out.println("ВЫберите человека и товар который хотите ему добавить (Выбирать по индексам) : ");
            int personIndex = scanner.nextInt();
            int productIndex = scanner.nextInt();
            if (personIndex < 1 || productIndex < 1) {
                break;
            }
            personList.get(personIndex - 1).addProductPacket(productList.get(productIndex - 1));
            System.out.println(personList.get(personIndex - 1));


        }

        System.out.println(personList);
    }

}
