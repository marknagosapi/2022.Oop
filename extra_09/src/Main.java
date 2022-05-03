public class Main {
    public static void main(String[] args){
        Aramkor aramkor = new Aramkor();
        Tranzisztor tranzisztor1 = new Tranzisztor(10);
        Tranzisztor tranzisztor2 = new Tranzisztor(42);

        Kondenzator kondenzator1 = new Kondenzator(12.42);
        Kondenzator kondenzator2 = new Kondenzator(100.4);

        Ellenallas ellenallas1 = new Ellenallas(1052.4);
        Ellenallas ellenallas2 = new Ellenallas(99.99);


        aramkor.add(tranzisztor1);
        aramkor.add(tranzisztor2);
        aramkor.add(kondenzator1);
        aramkor.add(kondenzator2);
        aramkor.add(ellenallas1);
        aramkor.add(ellenallas2);

    }
}
