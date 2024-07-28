package ru.innopolis.java.homework.homework05;

import java.util.Objects;

public class Tv {
    private String model;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    private int channel;
    private int volume;
    private boolean onOff;

    @Override
    public String toString() {
        return "Tv{" +
                "model='" + model + '\'' +
                ", channel=" + channel +
                ", volume=" + volume +
                ", onOff=" + onOff +
                ", diagonal='" + diagonal + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tv tv = (Tv) o;
        return channel == tv.channel && volume == tv.volume && onOff == tv.onOff && diagonal == tv.diagonal && model.equals(tv.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, channel, volume, onOff, diagonal);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    private int diagonal;

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }


    public int getDiagonal() {
        return diagonal;
    }

    public Tv(String model, int channel, int volume, boolean onOff, int diagonal) {
        this.model = model;
        this.channel = channel;
        this.volume = volume;
        this.onOff = onOff;
        this.diagonal = diagonal;
    }
}
