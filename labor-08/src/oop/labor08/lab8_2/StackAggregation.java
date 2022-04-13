package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackAggregation {
    //Variables
    private ArrayList<Object> items = new ArrayList<>();
    private final int capacity;

    //Constructor
    public StackAggregation(int capacity) {
        this.capacity = capacity;
    }

    //Methods
    public boolean isFull(){
        return items.size() >= capacity;
    }

    public boolean isEmpty(){
        return items.size()<=0;
    }

    public void push(Object object){
        if(!isFull()) {
            items.add(object);
        }
    }


    public void pop(){
        items.remove(items.size()-1);
    }

    public Object top(){
        if(isEmpty()){
            return null;
        }
        return items.get(items.size()-1);
    }

    public int getSize(){
        return items.size();
    }
}
