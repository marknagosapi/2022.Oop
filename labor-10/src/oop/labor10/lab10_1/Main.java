package oop.labor10.lab10_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

// Comparing Dates //

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> dates = new ArrayList<>();

        for(int i=0;i<10;){
            Random rand = new Random();
            MyDate d = new MyDate(2022, rand.nextInt(12)+1,rand.nextInt(32)+1);
            if(DateUtil.isValidDate(d.getYear(),d.getMonth(),d.getDay())){
                dates.add(d);
                i++;
            }
        }

        for(MyDate date: dates)
        {
            System.out.println(date.toString());

        }

        Collections.sort(dates);

        System.out.println();
        for(MyDate date: dates)
        {
            System.out.println(date.toString());

        }
    }
}
