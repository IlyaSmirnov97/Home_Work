package ru.innopolis.java.Ilya_Smirnov.homework07;

public class Child extends Person {

    public Child(String name, int amountOfMoney, int age) {
        super(name, amountOfMoney, age);
    }

    @Override
    public void addProductPacket(Product product) {
        if (super.getAge() < 6) {
            System.out.println("Ребенок не может совершать покупки");
        }else {
            super.addProductPacket(product);
        }

    }
}
