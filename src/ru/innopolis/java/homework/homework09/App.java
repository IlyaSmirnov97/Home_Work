package ru.innopolis.java.homework.homework09;

import ru.innopolis.java.homework.homework09.cars.Car;
import ru.innopolis.java.homework.homework09.cars.PerformanceCar;
import ru.innopolis.java.homework.homework09.cars.ShowCar;
import ru.innopolis.java.homework.homework09.races.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Чтение машин из файла
        List<Car> cars = readCarsFromFile("C:\\Users\\ilyas\\Учеба\\Home_Work2\\src\\ru\\innopolis\\java\\homework\\homework09\\cars.txt");

        // Создание объектов гонок
        CasualRace casualRace = new CasualRace(500, "City Circuit", 10000);
        DragRace dragRace = new DragRace(400, "Highway", 15000);
        DriftRace driftRace = new DriftRace(300, "Mountain Road", 12000);
        TimeLimitRace timeLimitRace = new TimeLimitRace(600, "Desert Road", 20000, 300);
        CircuitRace circuitRace = new CircuitRace(700, "Race Track", 25000, 5);

        // Добавление участников
        for (Car car : cars) {
            casualRace.getParticipants().add(car);
            dragRace.getParticipants().add(car);
            driftRace.getParticipants().add(car);
            timeLimitRace.getParticipants().add(car);
            circuitRace.getParticipants().add(car);
        }

        // Определение победителей гонок
        Car casualRaceWinner = casualRace.determineWinner();
        Car dragRaceWinner = dragRace.determineWinner();
        Car driftRaceWinner = driftRace.determineWinner();
        Car timeLimitRaceWinner = timeLimitRace.determineWinner();
        Car circuitRaceWinner = circuitRace.determineWinner();

        // Формирование результатов
        List<String> results = new ArrayList<>();
        results.add("На гонке: CasualRace\nПобеду одержала машина: " + casualRaceWinner);
        results.add("На гонке: DragRace\nПобеду одержала машина: " + dragRaceWinner);
        results.add("На гонке: DriftRace\nПобеду одержала машина: " + driftRaceWinner);
        results.add("На гонке: TimeLimitRace\nПобеду одержала машина: " + timeLimitRaceWinner);
        results.add("На гонке: CircuitRace\nПобеду одержала машина: " + circuitRaceWinner);

        // Запись результатов в файл
        writeResultsToFile("C:\\Users\\ilyas\\Учеба\\Home_Work2\\src\\ru\\innopolis\\java\\homework\\homework09\\race_results.txt", results);
    }

    private static List<Car> readCarsFromFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    cars.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
                } else if (parts.length == 8 && parts[7].equals("Performance")) {
                    cars.add(new PerformanceCar(parts[0], parts[1], Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
                } else if (parts.length == 9 && parts[8].equals("Show")) {
                    cars.add(new ShowCar(parts[0], parts[1], Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    private static void writeResultsToFile(String fileName, List<String> results) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String result : results) {
                bw.write(result);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

