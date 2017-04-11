package com.cbs.edu.vladimir.hw_01;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created by Vladimir on 06.04.2017.
 */
public class BestStack<T> implements Iterable<T> {
    private static final int SIZE = 6;
    private T[] myStack;
    private int top;

    public BestStack() {
        myStack = (T[]) new Object[SIZE];
        top = -1;
    }

    public T push(T object) {
        myStack[++top] = object;
        return object;
    }


    public T pop() throws EmptyStackException {

            T elem = myStack[top];
            myStack[top] = null;
            return elem;

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class BestIterator implements Iterator<T>{
        private int index;
        @Override
        public boolean hasNext() {
            return index < top;
        }

        @Override
        public T next() {
            return myStack[index--];
        }

        @Override
        public void remove() {
            myStack[index--] = null;
        }
    }
}



