package oop.labor02.feladat1;

public class Main {
    public static void main(String[] args) {
        /* FELADAT 2
        Auto auto = new Auto("kek");

        System.out.println("Az auto adatai: " + auto.toString());

        for(int i=0;i<12;i++){
            auto.novelSebesseg();
        }

        Auto auto2 = new Auto("sarga");

        for(int i=0;i<6;i++){
            auto2.novelSebesseg();
        }

        System.out.println("Az auto adatai: " + auto2.toString());

         */

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
