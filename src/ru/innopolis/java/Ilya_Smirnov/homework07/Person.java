package ru.innopolis.java.Ilya_Smirnov.homework07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double amountOfMoney = 0;
    private List<Product> productPackage = new ArrayList<>();
    private int age;

    public Person(String name, int amountOfMoney, int age) {
        if (name.equals(null) || name.length()<=0){
            throw new RuntimeException("Имя не может быть пустым");
        }
        this.name = name;
        this.amountOfMoney = amountOfMoney;
        this.age = age;
        if (age < 0){
            System.out.println("Возраст не может быть отрицательным");
            age = 0;
        }

        if (amountOfMoney < 0){
            //throw new RuntimeException("Баланс не может быть отрицательным");
            System.out.println("Баланс не может быть отрицательным");
        }
        this.productPackage = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals(null) || name.length()<=0){
            throw new RuntimeException("Имя не может быть пустым");
        }
        this.name = name;
    }
    public boolean checkPriceAndMoney(int sum) {
        return amountOfMoney - sum >= 0;
    }
    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney < 0){
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
        if(amountOfMoney > product.getPrice()){
            productPackage.add(product);
            amountOfMoney =amountOfMoney- product.getPrice();
            System.out.println(this.name + " купил " + product.getProductName() + " по цене: " + product.getPrice());
        }else {
            System.out.println(this.name + " не может позволить " + product.getProductName());
        }
    }
    @Override
    public String toString() {
        String result = "";
        if (productPackage.size() > 0) {
            for (Product product : productPackage) {
                result += product + " ";
            }
            result = result.trim();
            result = name + " " + result;
        } else
            result = name + " - Ничего не куплено";
        return result;
    }

    public int getAge() {
        return age;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
