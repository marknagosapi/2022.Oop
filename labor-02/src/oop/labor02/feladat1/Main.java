package oop.labor02.feladat1;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("kek");

        System.out.println("Az auto adatai: " + auto.toString());

        for (int i = 0; i < 12; i++) {
            auto.novelSebesseg();
        }

        Auto auto2 = new Auto("sarga");

        for (int i = 0; i < 6; i++) {
            auto2.novelSebesseg();
        }

        System.out.println("Az auto adatai: " + auto2.toString());

    }
}
