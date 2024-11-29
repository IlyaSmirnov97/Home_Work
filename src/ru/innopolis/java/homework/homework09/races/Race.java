package ru.innopolis.java.homework.homework09.races;

import ru.innopolis.java.homework.homework09.cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    // Пустой конструктор
    public Race() {
        this.participants = new ArrayList<>();
    }

    // Конструктор с параметрами
    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Car> participants) {
        this.participants = participants;
    }

    // Абстрактный метод для определения победителя
    public abstract Car determineWinner();

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizePool=" + prizePool +
                ", participants=" + participants +
                '}';
    }

    // Переопределение методов equals() и hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Race race = (Race) o;

        if (length != race.length) return false;
        if (prizePool != race.prizePool) return false;
        if (!route.equals(race.route)) return false;
        return participants.equals(race.participants);
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + route.hashCode();
        result = 31 * result + prizePool;
        result = 31 * result + participants.hashCode();
        return result;
    }
}
