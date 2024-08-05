package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework05;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Tv {
    private String model;
    private int volume;
    private boolean onOff;
    private int diagonal;
    private List<Channel> channelList = new ArrayList<>();
    private int nowChanelNumber;

    public int getNowChanelNumber() {

        return nowChanelNumber;
    }


    public void  printTv() {
        if (onOff) {
            System.out.println("Tv{" +
                    "model='" + model + '\'' +
                    ", volume=" + volume +
                    ", onOff=" + onOff +
                    ", diagonal=" + diagonal +
                    ", channelShow=" + channelList.get(nowChanelNumber) +
                    '}');

        } else {

            System.out.println("Tv{" +
                    "model='" + model + '\'' +
                    ", onOff=" + onOff +
                    ", diagonal=" + diagonal +
                    '}');
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tv tv = (Tv) o;
        return volume == tv.volume && onOff == tv.onOff && diagonal == tv.diagonal && model.equals(tv.model) && channelList.equals(tv.channelList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, volume, onOff, diagonal, channelList);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public Tv(String model, int volume, boolean onOff, int diagonal, List<Channel> channelList, int nowChanelNumber) {
        this.model = model;
        this.volume = volume;
        this.onOff = onOff;
        this.diagonal = diagonal;
        this.channelList = channelList;
        this.nowChanelNumber = nowChanelNumber;
    }

}
