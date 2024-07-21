package ru.innopolis.java.Ilya_Smirnov.six_homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private int amountOfMoney;
    private List<Product> productPackage = new ArrayList<>();


    public Person(String name, int amountOfMoney) {
        this.name = name;
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return name;
    }

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public List<Product> getProductPackage() {
        return productPackage;
    }

    public void productPacket(Product product) {
        productPackage.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getAmountOfMoney(),
                person.getAmountOfMoney()) && Objects.equals(getProductPackage(), person.getProductPackage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAmountOfMoney(), getProductPackage());
    }

    @Override
    public String toString() {
        String rezult = "";
        if (productPackage.size() > 0) {
            for (Product product : productPackage) {
                rezult += product + " ";
            }
            rezult = rezult.trim();
            rezult = name + " " + rezult;
        } else
            rezult = name + " - Ничего не куплено";
        return rezult;
    }

    public boolean checkPriceAndMoney(int sum) {
        return amountOfMoney - sum >= 0;
    }

}
