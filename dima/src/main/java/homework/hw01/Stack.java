package homework.hw01;

import java.util.ArrayList;

/**
 * Created by dimon on 06.04.2017.
 */
class Stack{
   private int size;
   private Object[] arrayStack;
    private int capacityGlobal;
    Stack(int capacity) {
        arrayStack = new Object[capacity];
        capacityGlobal = capacity;
    }

    void push(Object value) {
        if(size >= capacityGlobal) throw new IndexOutOfBoundsException("Stack is full");
        arrayStack[size++] = value;
    }

    Object pop() {
        if(size<=0) throw new IndexOutOfBoundsException("Stack can't be 0 or > 0");
        return arrayStack[--size];
    }

}