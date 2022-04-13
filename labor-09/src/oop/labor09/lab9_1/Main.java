package oop.labor09.lab9_1;

import oop.labor09.lab9_1.Queue.ArrayListQueue;
import oop.labor09.lab9_1.Queue.CircularQueue;
import oop.labor09.lab9_1.Queue.IQueue;

public class Main {
    public static void main(String[] args) {

        IQueue q1  =new ArrayListQueue(5);
        IQueue q2 = new ArrayListQueue(10);

        for(int i=0;i<5;i++){
            q1.enQueue(i);
            q2.enQueue(i);
        }

        q1.printQueue();
        q2.printQueue();

        System.out.println(q1.equals(q2));

        IQueue q3 = new CircularQueue(5);
        IQueue q4 = new CircularQueue(10);

        for(int i=0;i<5;i++){
            q3.enQueue(i);
            q4.enQueue(i);
        }

        q3.printQueue();
        q4.printQueue();


    }
}
