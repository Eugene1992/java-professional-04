package com.cbs.edu.vladimir.hw_01;

/**
 * Created by Vladimir on 06.04.2017.
 */
public class BestStack<Integer> {
    private int size;
    private int[] myStack;
    private int top;

    public BestStack(int max) {
        this.size = max;
        myStack = new int[size];
        top = -1;
    }

    public void push(int element) {
        try {

            myStack[++top] = element;
        } catch (RuntimeException e) {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        try {
            return myStack[top];
        } catch (RuntimeException e) {
            System.out.println("RuntimeException!!!");
        }
        return top;
    }
}


