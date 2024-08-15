package ru.innopolis.java.Ilya_Smirnov.homework07;

import java.util.Objects;

public class Product {
    private String productName;

    private double price;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Product(String productName, double price) {
        //System.out.println(isNumeric(productName));
        if ((isNumeric(productName)) || (productName.equals(null) || productName.length() <= 3)) {
            throw new RuntimeException("Недопустимое имя продукта!");
        }
        if (price < 0) {
            throw new RuntimeException("Цена не может быть отрицательной");
        }
        this.productName = productName;

        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
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
        return "Наименование товара: '" + productName + '\'' +
                ", Цена товара = " + price ;
    }

    public boolean isNumeric(String productName) {
        try {
            Double.parseDouble(productName);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
