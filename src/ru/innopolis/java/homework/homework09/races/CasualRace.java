package ru.innopolis.java.homework.homework09.races;

import ru.innopolis.java.homework.homework09.cars.Car;
import ru.innopolis.java.homework.homework09.races.Race;

public class CasualRace extends Race {
    // Пустой конструктор
    public CasualRace() {
        super();
    }

    // Конструктор с параметрами
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        Car winner = null;
        double highestScore = 0;

        for (Car car : getParticipants()) {
            double score = car.getHorsepower() * 0.5 + car.getDurability() * 0.5;
            if (score > highestScore) {
                highestScore = score;
                winner = car;
            }
        }

        return winner;
    }
}
