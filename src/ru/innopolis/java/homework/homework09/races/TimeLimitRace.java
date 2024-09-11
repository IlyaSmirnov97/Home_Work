package ru.innopolis.java.homework.homework09.races;

import ru.innopolis.java.homework.homework09.cars.Car;

public class TimeLimitRace extends Race {
    private int goldTime;

    // Пустой конструктор
    public TimeLimitRace() {
        super();
    }

    // Конструктор с параметрами
    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    // Геттеры и сеттеры
    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public Car determineWinner() {
        return super.getParticipants().stream().findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "goldTime=" + goldTime +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeLimitRace)) return false;
        if (!super.equals(o)) return false;

        TimeLimitRace that = (TimeLimitRace) o;

        return goldTime == that.goldTime;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + goldTime;
        return result;
    }
}
