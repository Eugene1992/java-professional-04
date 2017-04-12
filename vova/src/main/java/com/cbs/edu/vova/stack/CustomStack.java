package com.cbs.edu.vova.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Custom stack realization.
 *
 * @param <T> generic type
 */
public class CustomStack<T> implements Iterable {

    private int mSize;
    private int top;
    private T[] stackArray;

    /**
     * Creates stack with specified size.
     *
     * @param size specified size
     */
    public void createStack(int size) {
        this.mSize = size;
        stackArray = (T[]) new Object[mSize];
        top = -1;
    }

    /**
     * Adds new object into stack.
     *
     * @param element specified object
     */
    public void push(T element) {
        try {
            stackArray[++top] = element;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The stack is full!!!");
        }
    }

    /**
     * Retrieves the object from stack.
     *
     * @return retrieved object.
     * @throws EmptyStackException if stack is empty
     */
    public T pop() throws EmptyStackException {
        if (top == -1) {
            System.out.println("The stack is empty!!!");
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    /**
     * Check stack for empty size.
     *
     * @return logical result
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Check stack for full size.
     *
     * @return logical result
     */
    public boolean isFull() {
        return (top == mSize - 1);
    }


    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Iterator implementation.
     */
    private class MyIterator implements Iterator<T> {
        private int top = -1;

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
