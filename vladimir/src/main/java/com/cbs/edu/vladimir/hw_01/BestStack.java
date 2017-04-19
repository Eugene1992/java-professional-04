package com.cbs.edu.vladimir.hw_01;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 *
 * @param <T> tag.
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

    /**
     * Create method pop for BestStack class.
     */
    public T pop() throws EmptyStackException {
        T elem = myStack[top];
        myStack[top] = null;
        return elem;

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Created BestIterator for BestStack class.
     */
    private class BestIterator implements Iterator<T> {
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



