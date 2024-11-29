package ru.innopolis.java.homework.homework10Addition;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true

        System.out.println("First element: " + i);
        System.out.println("Second element: " + s);
        System.out.println("Are pairs equal? " + mustBeTrue);
        System.out.println("Do pairs have the same hash code? " + mustAlsoBeTrue);
    }
}
