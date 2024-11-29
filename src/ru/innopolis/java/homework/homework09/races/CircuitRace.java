package ru.innopolis.java.homework.homework09.races;

import ru.innopolis.java.homework.homework09.cars.Car;

public class CircuitRace extends Race {
    private int laps;

    // Пустой конструктор
    public CircuitRace() {
        super();
    }

    // Конструктор с параметрами
    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    // Геттеры и сеттеры
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public Car determineWinner() {
        return super.getParticipants().stream().findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "CircuitRace{" +
                "laps=" + laps +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CircuitRace)) return false;
        if (!super.equals(o)) return false;

        CircuitRace that = (CircuitRace) o;

        return laps == that.laps;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + laps;
        return result;
    }
}
