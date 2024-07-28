package ru.innopolis.java.homework.homework05;

import javax.swing.*;
import java.util.*;

public class App {

    public static void main(String[] args) {
        List<Tv> tvs = new ArrayList<>();
        for (int i=1; i <= 10; i++){
            boolean onOff;
            int channel = (int) (Math.random()*50) ;
            if (i%2==0){
                onOff = true;
            }else {
                onOff = false;
            }
            Tv tv = new Tv("model "+ i,channel,i*10,onOff,i+50);
            tvs.add(tv);

        }
        System.out.println("Выберите громкость телевизора:");
      Scanner scanner = new Scanner(System.in);
      int maxVolume = scanner.nextInt();
      Collections.sort(tvs, new Comparator<Tv>() {
          @Override
          public int compare(Tv o1, Tv o2) {
              return Integer.compare(o1.getChannel(), o2.getChannel());
          }
      });

        for (Tv tv: tvs) {
            if (tv.isOnOff() == true && tv.getVolume() <= maxVolume)

                System.out.println(tv);
        }
    }

}



