package ru.innopolis.java.Ilya_Smirnov.homework07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


/*Хлеб = 40 Молоко = 60 Торт = 800, 15% Кофе растворимый = 432, 50%*/
public class App {
    public static void main(String[] args) {

        //Создаем коллекции товаров со скидкой и без
        List<Product> productListDiscountOff = new ArrayList<>();
        List<Product> productListDiscountOn = new ArrayList<>();

        //
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
            System.out.println("Введите возраст пользователя для " + namePerson);
            int age = scanner.nextInt();
            Person person = PersonFactory.creatPerson(namePerson, money, age);
            personList.add(person);
        }

        //Добавляем товары
        System.out.println("Сколько будет Товаров?");
        int countProduct = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < countProduct; i++) {

            System.out.println("Введите название для товара " + (i + 1));
            String nameProduct = scanner.nextLine();
            System.out.println("Введите цену товара для " + nameProduct);
            int money = scanner.nextInt();
            System.out.println("У товара " + nameProduct + " Есть скеидка?  true/false ");
            boolean checkDiscount = scanner.nextBoolean();
            scanner.nextLine();
            Product product;
            if (checkDiscount == true) {
                System.out.println("Введите % скидки для товара " + nameProduct);
                int discount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите дату окончания скидки " + nameProduct);
                String dateDiscount = scanner.nextLine();
                LocalDate date = LocalDate.parse(dateDiscount);
                product = new DiscountProduct(nameProduct, money, discount, date);
            } else {
                product = new Product(nameProduct, money);
            }
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
