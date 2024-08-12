package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework05;

import javax.xml.namespace.QName;
import java.util.Objects;

public class TvProgram {
private String name;
private int raiting;
private int spectators;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getSpectators() {
        return spectators;
    }

    public void setSpectators(int spectators) {
        this.spectators = spectators;
    }

    @Override
    public String toString() {
        return "TvProgram{" +
                "name='" + name + '\'' +
                ", raiting=" + raiting +
                ", spectators=" + spectators +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvProgram tvProgram = (TvProgram) o;
        return raiting == tvProgram.raiting && spectators == tvProgram.spectators && name.equals(tvProgram.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, raiting, spectators);
    }

    public TvProgram(String name, int raiting, int spectators) {
        this.name = name;
        this.raiting = raiting;
        this.spectators = spectators;
    }
}
