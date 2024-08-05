package ru.innopolis.java.Ilya_Smirnov.HomeWork06.homework05;


import javax.swing.*;
import java.util.*;

public class App {

    public static void main(String[] args) {

        List<TvProgram> commonPrograms1 = new ArrayList<>();
        List<TvProgram> commonPrograms2 = new ArrayList<>();
        List<TvProgram> commonPrograms3 = new ArrayList<>();
        List<TvProgram> commonPrograms4 = new ArrayList<>();
        List<TvProgram> commonPrograms5 = new ArrayList<>();
        commonPrograms1.add(new TvProgram("Morning News", 5, 1000000));
        commonPrograms1.add(new TvProgram("Evening Show", 4, 800000));
        commonPrograms2.add(new TvProgram("Documentary", 5, 500000));
        commonPrograms2.add(new TvProgram("Sports Live", 4, 750000));
        commonPrograms3.add(new TvProgram("Movie Night", 4, 900000));
        commonPrograms3.add(new TvProgram("Late Night Talk", 3, 450000));
        commonPrograms4.add(new TvProgram("Cooking Show", 4, 600000));
        commonPrograms4.add(new TvProgram("Travel Diaries", 5, 700000));
        commonPrograms5.add(new TvProgram("Reality Show", 3, 400000));
        commonPrograms5.add(new TvProgram("Quiz Time", 4, 550000));

        // Создание и инициализация списка каналов, использующих общий список программ
        List<Channel> channelList = new ArrayList<>();
        channelList.add(new Channel("Channel One", 1, commonPrograms1));
        channelList.add(new Channel("Channel Two", 2, commonPrograms2));
        channelList.add(new Channel("Channel Three", 3, commonPrograms3));
        channelList.add(new Channel("Channel Four", 4, commonPrograms4));
        channelList.add(new Channel("Channel Five", 5, commonPrograms5));

        List<Tv> tvs = new ArrayList<>();
        System.out.println("Сколько теливизоров вы хотите рассмотреть?");
        Scanner scanner = new Scanner(System.in);
        int maxTv = scanner.nextInt();
        for (int i = 1; i <= maxTv; i++) {
            System.out.println("Включть model" + i + "? " + "Что бы включить введите true");
            Scanner scannerOnOff = new Scanner(System.in);
            boolean onOff = scannerOnOff.nextBoolean();
            if (onOff == true) {
                System.out.println("У нас есть 5 каналов, какой включить?");
                Scanner scannerChanel = new Scanner(System.in);
                int chanelNumber = scannerChanel.nextInt();
                System.out.println("Выберите громкость телевизора:");
                Scanner vol = new Scanner(System.in);
                int maxVolume = vol.nextInt();
                Tv tv = new Tv("model " + i, maxVolume, onOff, i + 50, channelList, chanelNumber);
                tvs.add(tv);
            } else {
                Tv tv = new Tv("model " + i, i * 10, onOff, i + 50, channelList, 1);
                tvs.add(tv);
            }


        }

        for (Tv tv : tvs) {
            tv.printTv();
        }


    }

}
