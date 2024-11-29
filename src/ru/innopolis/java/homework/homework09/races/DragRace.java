package ru.innopolis.java.homework.homework09.races;

import ru.innopolis.java.homework.homework09.cars.Car;
import ru.innopolis.java.homework.homework09.races.Race;

public class DragRace extends Race {
    // Пустой конструктор
    public DragRace() {
        super();
    }

    // Конструктор с параметрами
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        Car winner = null;
        int highestHorsepower = 0;

        for (Car car : getParticipants()) {
            if (car.getHorsepower() > highestHorsepower) {
                highestHorsepower = car.getHorsepower();
                winner = car;
            }
        }

        return winner;
    }
}
