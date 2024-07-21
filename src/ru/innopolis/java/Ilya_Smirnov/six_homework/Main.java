package ru.innopolis.java.Ilya_Smirnov.six_homework;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String personsString = "Павел   Андреевич   =   10000;   Анна Петровна = 2000; Борис = 10";
        String productsString = "Хлеб = 40; Молоко = 60; Торт = 1000;Кофе растворимый = 879; Масло = 150";
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
                "END"
        };

        //Создаем массивы клиентов и продуктов
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();


//        Строку из консоли конвертируем в данные класса Person
        System.out.println("Введите список покупателей");
        Scanner scanner = new Scanner(System.in);
//        personList = instansPerson(scanner.nextLine());
        personList = instansPerson(personsString);


        //        Строку из консоли конвертируем в данные класса Product
        System.out.println("Введите список продуктов");
//        productList = instansProduct(scanner.nextLine());
        productList = instansProduct(productsString);

        System.out.println("Введите данные о покупке. Если их нет, введите END");
//        String scannerOrder;
//        while (!(scannerOrder = scanner.nextLine()).equalsIgnoreCase("end")) {
//            inputPersonAndProducts(scannerOrder, personList, productList);
//        }

        for (var order : ordersString) {
            if (order.equalsIgnoreCase("end")) {
                break;
            }

            inputPersonAndProducts(order, personList, productList);
        }

        for (Person person : personList) {
            System.out.println(person.toString());
        }

        /*inputPersonAndProducts(personList, productList);
        printAll(personList, productList);*/


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
            Person person = new Person(name, amountOfMoney);
            result.add(person);
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
        if (person.checkPriceAndMoney(product.getPrice())) {
            person.productPacket(product);
            person.setAmountOfMoney(person.getAmountOfMoney() - product.getPrice());
            System.out.println(person.getName() + " купил " + product.getProductName());
        } else {
            System.out.println(person.getName() + " не может позволить себе " + product.getProductName());
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

    public static Product getProduct(List<Product> productList, String productName) {
        for (Product product : productList) {
            if (productName.contains(product.getProductName())) {
                return product;
            }
        }
        return null;
    }


    //    Сравниваем количество денег у покупателя с ценой товара

    //    Ввод с консоли данных о покупателе и товаре. Поиск их в списке, вызов метода checkPriceAndMoney,
//    добавление в корзину покупателя товар, который подошел

    //    Вывод на косоль результатов вноса данных
    public static void printAll(List<Person> personList, List<Product> productList) {
        for (Person person : personList) {
            for (Product product : productList) {
                if (Objects.equals(product.getProductName(), "")) {
                    System.out.println("Название продукта неможет быть пустой строкой");
                } else if (product.getPrice() < 0) {
                    System.out.println("Стоимость продукта не может быть отрицательным числом");
                }
                String listProduct = person.getProductPackage().toString();
                if (Objects.equals(person.getName(), "")) {
                    System.out.println("Имя не может быть пустой строкой");
                } else if (person.getAmountOfMoney() < 0) {
                    System.out.println("Деньги не могут быть отрицательными");
                } else if (person.getProductPackage().isEmpty()) {
                    System.out.println(person.getName() + " - Ничего не куплено");
                } else {
                    System.out.println(person.getName() + " - " + listProduct
                            .replace("[", "").replace("]", ""));
                }
            }
        }
    }

    //    Проверка всех исключающих ситуаций:
//    1. Сумма у покупателя не может быть отрицательной
//    2. Имя покупателя не может быть пустой строкой
//    3. Цена продукта не может быть отрицательной
//    4. Название продукта не может быть пустой строкой
    public static boolean validateParameters(Person person, Product product) {
        return Objects.equals(person.getName(), "") || person.getAmountOfMoney() < 0
                || Objects.equals(product.getProductName(), "") || product.getPrice() < 0;
    }
    
}
