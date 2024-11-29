package ru.innopolis.java.Ilya_Smirnov.homework07;

import java.util.Scanner;

public class Adult extends Person {
    private boolean credit = true;

    public Adult(String name, int amountOfMoney, int age) {
        super(name, amountOfMoney, age);
    }

    @Override
    public void addProductPacket(Product product) {
        if (super.getAmountOfMoney() < product.getPrice()) {
            System.out.println("Разрешить " + getName() + "взять товары в кредит? Если да, введите true. Если нет, введите false");
            Scanner scanner = new Scanner(System.in);
            this.credit = scanner.nextBoolean();
            if (credit == true) {
                setAmountOfMoney(getAmountOfMoney() + product.getPrice());
                System.out.println(getName() + " взял в кредит товар: " + product.getProductName());
            }else {
                System.out.println(getName() + " не может позволить " + product.getProductName());
            }

        }
        super.addProductPacket(product);
    }
}
