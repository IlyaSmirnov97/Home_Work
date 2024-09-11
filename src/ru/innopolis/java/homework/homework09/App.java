package ru.innopolis.java.homework.homework09;

import ru.innopolis.java.homework.homework09.cars.Car;
import ru.innopolis.java.homework.homework09.cars.PerformanceCar;
import ru.innopolis.java.homework.homework09.cars.ShowCar;
import ru.innopolis.java.homework.homework09.races.CasualRace;
import ru.innopolis.java.homework.homework09.races.DragRace;
import ru.innopolis.java.homework.homework09.races.DriftRace;

public class App {
    public static void main(String[] args) {
        // Создание объектов Car, PerformanceCar, ShowCar
        Car car1 = new Car("Toyota", "Camry", 2020, 200, 8, 5, 10);
        Car car2 = new Car("Honda", "Civic", 2019, 180, 9, 6, 11);
        PerformanceCar performanceCar1 = new PerformanceCar("Ferrari", "F8", 2021, 720, 3, 4, 9);
        PerformanceCar performanceCar2 = new PerformanceCar("Porsche", "911", 2022, 650, 4, 5, 8);
        ShowCar showCar1 = new ShowCar("Lamborghini", "Aventador", 2022, 770, 2, 4, 8, 5);
        ShowCar showCar2 = new ShowCar("Bugatti", "Chiron", 2023, 1500, 1, 3, 10, 7);

        // Создание объектов гонок
        CasualRace casualRace = new CasualRace(500, "City Circuit", 10000);
        casualRace.getParticipants().add(car1);
        casualRace.getParticipants().add(car2);
        casualRace.getParticipants().add(performanceCar1);
        casualRace.getParticipants().add(performanceCar2);
        casualRace.getParticipants().add(showCar1);
        casualRace.getParticipants().add(showCar2);

        DragRace dragRace = new DragRace(400, "Highway", 15000);
        dragRace.getParticipants().add(car1);
        dragRace.getParticipants().add(car2);
        dragRace.getParticipants().add(performanceCar1);
        dragRace.getParticipants().add(performanceCar2);
        dragRace.getParticipants().add(showCar1);
        dragRace.getParticipants().add(showCar2);

        DriftRace driftRace = new DriftRace(300, "Mountain Road", 12000);
        driftRace.getParticipants().add(car1);
        driftRace.getParticipants().add(car2);
        driftRace.getParticipants().add(performanceCar1);
        driftRace.getParticipants().add(performanceCar2);
        driftRace.getParticipants().add(showCar1);
        driftRace.getParticipants().add(showCar2);

        // Создание объекта Garage и добавление машин
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(performanceCar1);
        garage.addCar(performanceCar2);
        garage.addCar(showCar1);
        garage.addCar(showCar2);

        // Модификация машин в гараже
        garage.modifyCar(car1, 250, 7, 6, 12);
        garage.modifyCar(car2, 200, 8, 7, 13);
        garage.modifyCar(performanceCar1, 800, 2, 5, 10);
        garage.modifyCar(performanceCar2, 750, 3, 6, 9);
        garage.modifyCar(showCar1, 800, 2, 5, 10);
        garage.modifyCar(showCar2, 1550, 1, 4, 12);

        // Определение победителей гонок
        Car casualRaceWinner = casualRace.determineWinner();
        Car dragRaceWinner = dragRace.determineWinner();
        Car driftRaceWinner = driftRace.determineWinner();

        // Вывод информации
        System.out.println("Casual Race Winner: " + casualRaceWinner);
        System.out.println("Drag Race Winner: " + dragRaceWinner);
        System.out.println("Drift Race Winner: " + driftRaceWinner);
        System.out.println(garage);
    }
}
