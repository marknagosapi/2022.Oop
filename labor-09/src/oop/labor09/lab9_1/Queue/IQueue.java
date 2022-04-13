package oop.labor09.lab9_1.Queue;

public interface IQueue {

    void enQueue(Object a);
    Object deQueue();
    void printQueue();
    boolean isEmpty();
    boolean isFull();

}
