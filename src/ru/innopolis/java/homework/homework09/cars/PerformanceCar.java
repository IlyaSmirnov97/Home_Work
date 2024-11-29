package ru.innopolis.java.homework.homework09.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    // Пустой конструктор
    public PerformanceCar() {
        super();
        this.addOns = new ArrayList<>();
    }

    // Конструктор с параметрами
    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
        // Увеличенная мощность двигателя на 50%
        setHorsepower((int) (horsepower * 1.5));
        // Уменьшенная подвеска на 25%
        setSuspension((int) (suspension * 0.75));
    }

    // Геттеры и сеттеры
    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", horsepower=" + getHorsepower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", addOns=" + addOns +
                '}';
    }

    // Переопределение методов equals() и hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PerformanceCar that = (PerformanceCar) o;

        return addOns.equals(that.addOns);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + addOns.hashCode();
        return result;
    }
}
