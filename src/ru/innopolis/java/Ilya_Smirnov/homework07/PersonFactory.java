package ru.innopolis.java.Ilya_Smirnov.homework07;

public class PersonFactory {
    public static Person creatPerson(String name, int amountOfMoney, int age) {
        if (age <= 17) {
            return new Child(name, amountOfMoney, age);
        }
        if (age < 65) {
            return new Adult(name, amountOfMoney, age);
        }
        return new Pensioner(name, amountOfMoney, age);
    }
}
