package feladat2;

public class Main {
    public static void main(String[] args) {
        Bankszamla szamla = new Bankszamla(1000);
        System.out.println(szamla.getEgyenleg());
        szamla.betesz(500);
        szamla.kivesz(2000);
        System.out.println(szamla.getEgyenleg());
        szamla.kivesz(2000);
        System.out.println(szamla.getEgyenleg());
    }
}
