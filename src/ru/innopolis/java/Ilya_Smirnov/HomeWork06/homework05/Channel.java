package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/*Следующую программу сохранить в ветке
git homeworks/homework06отдельным коммитом/коммитами.
Дополнить  модель   предметной   области   “Телевизор”.
Создать   длятелевизора   поле   с   набором   Каналов.
Канал   характеризуется   названием,порядковым   номером   и   Программой.
Программа   —   отдельный   класс   сназванием, рейтингом и числом зрителей.
У каждой  сущности  есть поля  и, как  минимум, 2 метода.
Телевизордополнить методом включения/выключения и переключения канала (если ранеене были реализованы).
Конструкторы, геттеры/сеттеры задать объектам по необходимости. Полязаданы как private.
У классов переопределен метод toString(), а также методыequals() и hashcode().
Проверить работу с сущностями в классе App, методе main.
 */
public class Channel {
    private String name;
    private int number;
    private List<TvProgram> programs = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<TvProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(List<TvProgram> programs) {
        this.programs = programs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return number == channel.number && name.equals(channel.name) && programs.equals(channel.programs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, programs);
    }

    @Override
    public String toString() {
        int randomProgram = new Random().nextInt(programs.size() - 1);
        return "Channel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", nowPrograms=" + programs.get(randomProgram) +
                '}';
    }

    public Channel(String name, int number, List<TvProgram> programs) {
        this.name = name;
        this.number = number;
        this.programs = programs;
    }
}