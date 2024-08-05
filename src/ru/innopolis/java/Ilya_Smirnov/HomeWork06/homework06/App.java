package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework06;

import java.util.*;

public class App {
    public static void main(String[] args) {

        String personsString = "Павел   Андреевич   =   10000;   Анна Петровна = 2000; Борис = 10;Женя = 0; Света = -3"; //Света = -3
        String productsString = "Хлеб = 40; Молоко = 60; Торт = 1000;Кофе растворимый = 879; Масло = 150; Мороженое = 200;Макароны = 800";
        String[] ordersString = new String[]{
                "Павел Андреевич Хлеб",
                "Павел Андреевич  Масло",
                "Анна Петровна  Кофе растворимый",
                "Анна Петровна   Молоко",
                "Анна Петровна   Молоко",
                "Анна Петровна   Молоко",
                "Анна Петровна  Торт",
                "Борис Торт",
                "Павел Андреевич  Торт",
                "Женя Мороженое",
                "Света Макароны",
                "END"
        };

        //Создаем массивы клиентов и продуктов
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();


//        Строку конвертируем в данные класса Person и Product
        personList = instansPerson(personsString);
        productList = instansProduct(productsString);
        
        for (var order : ordersString) {
            if (order.equalsIgnoreCase("end")) {
                break;
            }
            inputPersonAndProducts(order, personList, productList);
        }

        for (Person person : personList) {
            System.out.println(person.toString());
        }


    }

    public static List<Person> instansPerson(String text) {
        String[] rawPersons = text.split(";");
        List<Person> result = new ArrayList<>();
        for (String rawPerson : rawPersons) {
            String[] tokens = rawPerson.split("=");

            if (tokens.length != 2) {
                continue;
            }

            String name = parseName(tokens[0]);
            int amountOfMoney = parseAmountOfMoney(tokens[1]);
            if (amountOfMoney < 0){
                System.out.println("Баланс не может быть отрицательным: " + name);
            }else {
                Person person = new Person(name, amountOfMoney);
                result.add(person);
            }

        }
        return result;
    }

    private static int parseAmountOfMoney(String rawInput) {
        return Integer.parseInt(rawInput.trim());
    }

    private static String parseName(String rawInput) {
        StringJoiner joiner = new StringJoiner(" ");
        for (String token : rawInput.split(" ")) {
            if (!token.isBlank()) {
                joiner.add(token);
            }
        }
        return joiner.toString();
    }

    public static List<Product> instansProduct(String text) {
        String[] rawProducts = text.split(";");
        List<Product> result = new ArrayList<>();
        for (String rawProduct : rawProducts) {
            String[] tokens = rawProduct.split("=");

            String name = parseName(tokens[0]);
            int amountOfMoney = parseAmountOfMoney(tokens[1]);
            Product currentProduct = new Product(name, amountOfMoney);
            result.add(currentProduct);
        }
        return result;
    }

    private static void inputPersonAndProducts(String order, List<Person> personList, List<Product> productList) {
        Person person = getPerson(personList, order);
        Product product = getProduct(productList, order);
        if (person != null) {
            person.addProductPacket(product);
        }
    }

    private static Person getPerson(List<Person> personList, String name) {
        for (Person person : personList) {
            if (name.contains(person.getName())) {
                return person;
            }
        }
        return null;
    }
//
    public static Product getProduct(List<Product> productList, String productName) {
        for (Product product : productList) {
            if (productName.contains(product.getProductName())) {
                return product;
            }
        }
        return null;
    }
}
