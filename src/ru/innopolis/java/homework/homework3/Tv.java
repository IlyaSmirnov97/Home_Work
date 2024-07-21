package ru.innopolis.java.homework.homework3;

public class Tv {
    private String model;

    @Override
    public String toString() {
        return model + " " + diagonal;
    }

    public Tv(String model, String diagonal) {
        this.model = model;
        this.diagonal = diagonal;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

private String diagonal;

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public Tv() {
        this.model = "" ;
    }

    public String getDiagonal() {
        return diagonal;
    }
}
