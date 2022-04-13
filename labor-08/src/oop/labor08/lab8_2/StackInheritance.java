package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object>{
    //Variables
    private final int capacity;

    //Constructor
    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }

    //Methods
    public boolean isFull(){
        return super.size() >= capacity;
    }

    public boolean isEmpty(){
        return super.size()<=0;
    }

    public void push(Object object){
        if(!isFull()) {
            super.add(object);
        }
    }

    public void pop(){
        super.remove(super.size()-1);
    }

    public Object top(){
        if(isEmpty()){
            return null;
        }
        return super.get(super.size()-1);
    }

    public int getSize(){
        return super.size();
    }
}
