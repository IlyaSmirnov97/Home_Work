package ru.innopolis.java.Ilya_Smirnov.homework07;

public class Pensioner extends Person {
    public Pensioner(String name, int amountOfMoney, int age) {
        super(name, amountOfMoney, age);
    }
    @Override
    public void addProductPacket(Product product) {
        Product productDiscount = new Product(product.getProductName(), product.getPrice()  / 100 * 95);
        super.addProductPacket(productDiscount);
        }
}
