package oop.labor09.lab9_1.Queue;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue {

    //Variables
    private ArrayList<Object> items = new ArrayList<>();
    private int CAPACITY;


    //Constructor
    public ArrayListQueue(int cap){
        this.CAPACITY = cap;
    }


    //Methods
    @Override
    public void enQueue(Object a) {

        if(!(isFull())){
            items.add(a);
        }
    }

    @Override
    public Object deQueue() {
        if(!(isEmpty())){
            Object o = items.get(0);
            items.remove(0);
            return o;
        }
        return null;
    }

    @Override
    public void printQueue() {
        if(!isEmpty()) {
            for (Object o : items) {
                System.out.print(" "+o);
            }
            System.out.println();
        } else{
            System.out.println("The Queue is empty!");
        }
    }

    @Override
    public boolean isEmpty() {
        return items.size() <= 0;
    }

    @Override
    public boolean isFull() {
        return items.size() >= this.CAPACITY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListQueue that = (ArrayListQueue) o;
        if(this.items.size() != that.items.size()){
            return false;
        }
        for(int i=0;i<this.items.size();i++){
            if(!(this.items.get(i).equals(that.items.get(i)))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, CAPACITY);
    }
}
