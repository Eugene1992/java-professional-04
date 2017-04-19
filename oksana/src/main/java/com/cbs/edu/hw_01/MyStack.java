package com.cbs.edu.hw_01;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Custom Stack implementation.
 * @param <T> generic type
 */
public class MyStack<T> implements Iterable<T> {

    private static final int INITIAL_ARRAY_CAPACITY = 5;
    private T[] arr;
    private int top;

    public MyStack() {
        this.top = 0;
        this.arr = (T[]) new Object[INITIAL_ARRAY_CAPACITY];
    }

    /**
     * Adds new object into stack.
     *
     * @param object specified object
     * @return saved object
     */
    public T push(T object) {
        if (top == arr.length) {
            T[] newArr = (T[]) new Object[2 * this.arr.length];
            System.arraycopy(this.arr, 0, newArr, 0, this.top);
            this.arr = newArr;
        }
        this.arr[top++] = object;
        return object;
    }

    /**
     * Retrieves the object from stack.
     *
     * @return retrieved object.
     * @throws EmptyStackException if stack is empty
     */
    public T pop() throws EmptyStackException {
        if (top == 0) {
            throw new EmptyStackException();
        } else {
            T elem = arr[--top];
            arr[top] = null;
            return elem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Iterator implementation.
     */
    private class MyIterator implements Iterator<T> {
        private int current = -1;

        public boolean hasNext() {
            return current + 1 < top;
        }

        public T next() {
            return arr[++current];
        }

        public void remove() {
            arr[current] = null;
        }
    }
}


