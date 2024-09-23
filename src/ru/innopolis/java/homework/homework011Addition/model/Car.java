package ru.innopolis.java.homework.homework011Addition.model;

public class Car {
    // Поля класса
    private String number;
    private String model;
    private String color;
    private int mileage;
    private int cost;

    // Конструктор класса
    public Car(String number, String model, String color, int mileage, int cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    // Геттеры и сеттеры
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // Переопределение метода toString для удобного вывода информации об автомобиле
    @Override
    public String toString() {
        return String.format("Number: %s, Model: %s, Color: %s, Mileage: %d, Cost: %d", number, model, color, mileage, cost);
    }
}

