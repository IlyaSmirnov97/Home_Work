package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int amountOfMoney = 0;
    private List<Product> productPackage = new ArrayList<>();

    public Person(String name, int amountOfMoney) {
        if (name.equals(null) || name.length() <= 0) {
            throw new RuntimeException("Имя не может быть пустым");
        }
        this.name = name;
        setAmountOfMoney(amountOfMoney);
        this.productPackage = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals(null) || name.length() <= 0) {
            throw new RuntimeException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public boolean checkPriceAndMoney(int sum) {
        return amountOfMoney - sum >= 0;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney < 0) {
            throw new RuntimeException("Баланс не может быть отрицательным");
        }
        this.amountOfMoney = amountOfMoney;
    }

    public List<Product> getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(List<Product> productPackage) {
        this.productPackage = productPackage;
    }

    public void addProductPacket(Product product) {
        if (amountOfMoney >= product.getPrice()) {
            productPackage.add(product);
            amountOfMoney = amountOfMoney - product.getPrice();
            System.out.println(this.name + " купил " + product.getProductName());
        } else {
            System.out.println(this.name + " не может позволить " + product.getProductName());
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (productPackage.size() > 0) {
            for (Product product : productPackage) {
                result += product.getProductName() + " ";
            }
            result = result.trim();
            result = name + " Баланс " + amountOfMoney + " Корзина: " + result;
        } else
            result = name + " - Ничего не куплено";
        return result;
    }
}
