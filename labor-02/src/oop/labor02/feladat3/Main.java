package oop.labor02.feladat3;

import oop.labor02.feladat3.Datum;

public class Main {
    public static void main(String[] args) {
        // FELADAT 3
        Datum datum = new Datum(2016, 12, 1);

        //We print out the date on console if it is a leap year!
        System.out.println("Date:" + datum.toString());
        if(datum.szokoEv(datum.getEv())) {
            //System.out.printf("Date: %d/%d/%d\n", datum.getEv(), datum.getHo(), datum.getNap());
            //System.out.println("Datum:" + datum.toString());
            System.out.println("Szokoev!");
        }

    }
}
