package ru.innopolis.java.homework.homework09.races;

import ru.innopolis.java.homework.homework09.cars.Car;
import ru.innopolis.java.homework.homework09.races.Race;

public class DriftRace extends Race {
    // Пустой конструктор
    public DriftRace() {
        super();
    }

    // Конструктор с параметрами
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        Car winner = null;
        int highestSuspension = 0;

        for (Car car : getParticipants()) {
            if (car.getSuspension() > highestSuspension) {
                highestSuspension = car.getSuspension();
                winner = car;
            }
        }

        return winner;
    }
}
