package ru.innopolis.java.homework.homework09;

import ru.innopolis.java.homework.homework09.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    // Пустой конструктор
    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    // Метод для добавления машины в гараж
    public void addCar(Car car) {
        this.parkedCars.add(car);
    }

    // Метод для удаления машины из гаража
    public void removeCar(Car car) {
        this.parkedCars.remove(car);
    }

    // Метод для модификации машины
    public void modifyCar(Car car, int newHorsepower, int newAcceleration, int newSuspension, int newDurability) {
        if (this.parkedCars.contains(car)) {
            car.setHorsepower(newHorsepower);
            car.setAcceleration(newAcceleration);
            car.setSuspension(newSuspension);
            car.setDurability(newDurability);
        } else {
            System.out.println("The car is not in the garage.");
        }
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }

    // Переопределение методов equals() и hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garage garage = (Garage) o;

        return parkedCars.equals(garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return parkedCars.hashCode();
    }
}
