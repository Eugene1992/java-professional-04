package com.cbs.edu.vova.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Custom stack realization.
 */
public class CustomStack<T> implements Iterable {
    private int mSize;
    private int top;
    private T[] stackArray;

    public void createStack(int size) {
        this.mSize = size;
        stackArray = (T[]) new Object[mSize];
        top = -1;
    }

    public void push(T element) {
        try {
            stackArray[++top] = element;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The stack is full!!!");
        }
    }

    public T pop() throws EmptyStackException {
        if (top == -1) {
            System.out.println("The stack is empty!!!");
            throw new EmptyStackException();
        }
        return stackArray[top--];

    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == mSize - 1);
    }


    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int top = -1;

        public boolean hasNext() {
            return top + 1 < mSize;
        }

        public T next() {
            return stackArray[++top];
        }

        public void remove() {
            stackArray[top--] = null;
        }
    }
}
