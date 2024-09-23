package ru.innopolis.java.homework.homework011Addition.test;

import ru.innopolis.java.homework.homework011Addition.repository.CarsRepository;
import ru.innopolis.java.homework.homework011Addition.repository.CarsRepositoryImpl;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Инициализируем репозиторий и файл для ввода/вывода
        CarsRepository carsRepository = new CarsRepositoryImpl();
        String inputFileName = "C:\\Users\\ilyas\\Учеба\\Home_Work2\\src\\ru\\innopolis\\java\\homework\\homework011Addition\\data\\cars.txt";
        String outputFileName = "C:\\Users\\ilyas\\Учеба\\Home_Work2\\src\\ru\\innopolis\\java\\homework\\homework011Addition\\data\\result.txt";

        // Читаем автомобили из файла
        carsRepository.loadFromFile(inputFileName);

        // Создаем PrintStream для записи всех выводов в файл
        try (PrintStream ps = new PrintStream(new FileOutputStream(outputFileName))) {
            // Переопределяем System.out для записи в файл
            System.setOut(ps);

            // Вывод всех автомобилей
            System.out.println("Автомобили в базе:");
            carsRepository.getAllCars().forEach(System.out::println);

            // Номера автомобилей по цвету или пробегу
            String colorToFind = "Black";
            int mileageToFind = 0;
            List<String> carNumbersByColorOrMileage = carsRepository.getCarNumbersByColorOrMileage(colorToFind, mileageToFind);
            System.out.println("\nНомера автомобилей по цвету или пробегу: " + String.join(", ", carNumbersByColorOrMileage));

            // Количество уникальных моделей в ценовом диапазоне
            int n = 700000;
            int m = 800000;
            long uniqueModelsInRange = carsRepository.countUniqueModelsInRange(n, m);
            System.out.println("\nУникальные автомобили: " + uniqueModelsInRange + " шт.");

            // Цвет автомобиля с минимальной стоимостью
            String colorOfMinCostCar = carsRepository.getColorOfMinCostCar();
            System.out.println("Цвет автомобиля с минимальной стоимостью: " + colorOfMinCostCar);

            // Средняя стоимость искомой модели
            String modelToFind = "Toyota";
            double averageCostOfModel = carsRepository.getAverageCostOfModel(modelToFind);
            System.out.printf("Средняя стоимость модели %s: %.2f%n", modelToFind, averageCostOfModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




