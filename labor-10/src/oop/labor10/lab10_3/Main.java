package oop.labor10.lab10_3;

public class Main {
    public static void main(String[] args){

        //STORAGE 1
        Storage storage = new Storage("data10.txt");

        long start = System.nanoTime();
        storage.update("update10.txt");
        // some time passes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("[UPDATE] Time of the update: %.3f sec ".formatted((double)elapsedTime/10000000));


        //STORAGE 2
        System.out.println("\t\t\tSTORAGE 1");
        Storage storage2 = new Storage("data1000.txt");

        long start2 = System.nanoTime();
        storage2.update("update1000.txt");
        // some time passes
        long end2 = System.nanoTime();
        long elapsedTime2 = end2 - start2;
        System.out.println("[UPDATE] Time of the update: %.3f sec ".formatted((double)elapsedTime2/10000000));


        //STORAGE 3
        System.out.println("\t\t\tSTORAGE 2");
        Storage storage3 = new Storage("data1000.txt");

        long start3 = System.nanoTime();
        storage3.update("update1000000.txt");
        // some time passes
        long end3 = System.nanoTime();
        long elapsedTime3 = end3 - start3;
        System.out.println("[UPDATE] Time of the update: %.3f sec ".formatted((double)elapsedTime3/10000000));

        //STORAGE 4
        System.out.println("\t\t\tSTORAGE 3");
        Storage storage4 = new Storage("data1000000.txt");

        long start4 = System.nanoTime();
        storage4.update("update1000.txt");
        // some time passes
        long end4 = System.nanoTime();
        long elapsedTime4 = end4 - start4;
        System.out.println("[UPDATE] Time of the update: %.3f sec ".formatted((double)elapsedTime4/10000000));

        //STORAGE 5
        System.out.println("\t\t\tSTORAGE 4");
        Storage storage5 = new Storage("data100000.txt");

        long start5 = System.nanoTime();
        storage5.update("update1000000.txt");
        // some time passes
        long end5 = System.nanoTime();
        long elapsedTime5 = end5 - start5;
        System.out.println("[UPDATE] Time of the update: %.3f sec ".formatted((double)elapsedTime5/10000000));
    }
}
