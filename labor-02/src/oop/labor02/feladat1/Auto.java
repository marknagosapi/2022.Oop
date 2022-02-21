package oop.labor02.feladat1;

public class Auto{
    private String szin="FEHER";
    private int sebesseg = 0;

    public Auto(){

    }

    public Auto(String szin){
        this.szin = szin;
    }

    public int getSebesseg(){
        return sebesseg;
    }

    public void novelSebesseg(){
        this.sebesseg += 10;
    }

    public String toString(){
        return szin + " " + sebesseg;
    }
}