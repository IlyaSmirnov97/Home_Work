package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework06;

import java.util.Objects;

public class Product {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        if (productName.equals(null) || productName.length()<=0){
            throw new RuntimeException("Название товара не может быть пустым");
        }
        if (price < 0){
            throw new RuntimeException("Цена не может быть отрицательной");
        }
        this.productName = productName;

        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() && Objects.equals(getProductName(), product.getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getPrice());
    }

    @Override
    public String toString() {
        return productName;
    }
}
