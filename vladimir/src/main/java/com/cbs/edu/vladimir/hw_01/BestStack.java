package com.cbs.edu.vladimir.hw_01;

/**
 * Created by Vladimir on 06.04.2017.
 */
public class BestStack {
    private int size;
    private int[] myStack;
    private int top;

    public BestStack(int max) {
        this.size = max;
        myStack = new int[size];
        top = -1;
    }

    /**
     * Adds new object into stack.
     *
     * @param element specified object
     */
    public void push(int element) {
        try {
            myStack[++top] = element;
        } catch (RuntimeException e) {
            System.out.println("Stack is full");
        }
    }

    /**
     * Retrieves the object from stack.
     *
     * @return retrieved object.
     */
    public int pop() {
        try {
            return myStack[top];
        } catch (RuntimeException e) {
            System.out.println("RuntimeException!!!");
        }
        return top;
    }
}


