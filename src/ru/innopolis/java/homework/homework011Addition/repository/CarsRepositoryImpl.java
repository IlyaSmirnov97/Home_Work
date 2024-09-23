package ru.innopolis.java.homework.homework011Addition.repository;



import ru.innopolis.java.homework.homework011Addition.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<String> getCarNumbersByColorOrMileage(String color, int mileage) {
        return cars.stream()
                .filter(car -> car.getColor().equals(color) || car.getMileage() == mileage)
                .map(Car::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public long countUniqueModelsInRange(int minPrice, int maxPrice) {
        return cars.stream()
                .filter(car -> car.getCost() >= minPrice && car.getCost() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
    }

    @Override
    public String getColorOfMinCostCar() {
        return cars.stream()
                .min(Comparator.comparingInt(Car::getCost))
                .map(Car::getColor)
                .orElse("Unknown");
    }

    @Override
    public double getAverageCostOfModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equals(model))
                .mapToInt(Car::getCost)
                .average()
                .orElse(0.0);
    }

    @Override
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String number = parts[0];
                    String model = parts[1];
                    String color = parts[2];
                    int mileage = Integer.parseInt(parts[3]);
                    int cost = Integer.parseInt(parts[4]);
                    cars.add(new Car(number, model, color, mileage, cost));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            for (Car car : cars) {
                pw.println(car.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





