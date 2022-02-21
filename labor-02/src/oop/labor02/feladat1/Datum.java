package oop.labor02.feladat1;

import static java.sql.Types.NULL;

public class Datum {
    private int ev, ho, nap;
    //Konstruktor
    public Datum(int pev, int pho, int pnap) {
        if (helyesDatum(pev, pho, pnap)) {
            ev = pev;
            ho = pho;
            nap = pnap;
        }
    }

    public int getEv(){
        return ev;
    }

    public int getHo(){
        return ho;
    }

    public int getNap(){
        return nap;
    }

    public String toString(){
        return ev + "/" + ho + "/" +nap;
    }

    public  boolean helyesDatum(int ev, int ho,int nap){
        if(ev < 1 || ev > 2022){
            return false;
        }

        if(ho < 1 || ho > 12){
            return false;
        }

        if(nap < 1 || nap > 31){
            return false;
        }
        return true;
    }

    public boolean szokoEv(int ev){

        if(ev%4==0){
            if(ev%100==0){
                return ev % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

}
