package ru.innopolis.java.homework.homework011;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем список автомобилей
        List<Car> cars = Arrays.asList(
                new Car("a123me", "Mercedes", "White", 0, 8300000),
                new Car("b873of", "Volga", "Black", 0, 673000),
                new Car("w487mn", "Lexus", "Grey", 76000, 900000),
                new Car("p987hj", "Volga", "Red", 610, 704340),
                new Car("c987ss", "Toyota", "White", 254000, 761000),
                new Car("o983op", "Toyota", "Black", 698000, 740000),
                new Car("p146op", "BMW", "White", 271000, 850000),
                new Car("u893ii", "Toyota", "Purple", 210900, 440000),
                new Car("l097df", "Toyota", "Black", 108000, 780000),
                new Car("y876wd", "Toyota", "Black", 160000, 1000000)
        );

        // Вывод всех автомобилей
        System.out.println("Автомобили в базе:");
        cars.forEach(System.out::println);

        // Номера автомобилей по цвету или пробегу
        String colorToFind = "Black";
        int mileageToFind = 0;
        List<String> carNumbersByColorOrMileage = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());
        System.out.println("\nНомера автомобилей по цвету или пробегу: " + String.join(", ", carNumbersByColorOrMileage));

        // Количество уникальных моделей в ценовом диапазоне
        int n = 700000;
        int m = 800000;
        long uniqueModelsInRange = cars.stream()
                .filter(car -> car.getCost() >= n && car.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("\nУникальные автомобили: " + uniqueModelsInRange + " шт.");

        // Цвет автомобиля с минимальной стоимостью
        String colorOfMinCostCar = cars.stream()
                .min(Comparator.comparingInt(Car::getCost))
                .map(Car::getColor)
                .orElse("Unknown");
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + colorOfMinCostCar);

        // Средняя стоимость искомой модели
        String modelToFind = "Toyota";
        double averageCostOfModel = cars.stream()
                .filter(car -> car.getModel().equals(modelToFind))
                .mapToInt(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.printf("Средняя стоимость модели %s: %.2f%n", modelToFind, averageCostOfModel);
    }
}

