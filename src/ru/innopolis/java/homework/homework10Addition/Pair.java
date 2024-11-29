package ru.innopolis.java.homework.homework10Addition;

import java.util.Objects;

public class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    // Приватный конструктор
    private Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    // Статический фабричный метод
    public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

    // Метод для получения первого элемента
    public T1 getFirst() {
        return first;
    }

    // Метод для получения второго элемента
    public T2 getSecond() {
        return second;
    }

    // Переопределение equals() для проверки равенства
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    // Переопределение hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

