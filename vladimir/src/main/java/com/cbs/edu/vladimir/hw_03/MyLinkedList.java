package com.cbs.edu.vladimir.hw_03;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Vladimir on 16.04.2017.
 * @param <T> tag.
 */
public class MyLinkedList<T> implements Iterable<T> {

    private T[] array;
    private int top;
    private int capacity;

    /**
     * create construction.
     */
    public MyLinkedList(int capasity) {
        this.array = (T[]) new Object[capasity];
        this.capacity = capasity;
    }

    /**
     * add.
     */
    public void add(T value) {
        if (capacity == array.length) {
            final int newCapasity = array.length * 3 / 2 + 1;
            this.array = (T[]) new Object[newCapasity];
            array[top++] = value;
        }
        array[++top] = value;
    }

    /**
     * AddIndex.
     */
    public void addIndex(Integer index, T value) {
        if (capacity == array.length) {
            final int newCapasity = array.length * 3 / 2 + 1;
            this.array = (T[]) new Object[newCapasity];
            array[index] = value;
        }
        array[index] = value;
    }

    public T get(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("index < 0 | index > array.length ");
        }
        return array[index];
    }

    public void set(Integer index, T value) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("index < 0 | index > array.length ");
        }
        array[index] = value;
    }

    /**
     * MyList contains.
     */
    public boolean contains(T value) {
        for (int i = 0; i < array.length - 1; i++) {
            if (this.array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        this.array[index] = null;
    }

    /**
     * MyList size.
     */
    public int size() {
        int x = 0;
        for (int i = 0; i <= this.array.length; i++) {
            x = i;
        }
        return x;
    }

    @Override
    public String toString() {
        return "MyList{" + "array=" + Arrays.toString(array) + ", capacity=" + capacity + ", top=" + top + '}';
    }

    @Override
    public Iterator<T> iterator() {
        MyIterator myIterator = new MyIterator();
        return myIterator;
    }

    /**
     * Class MyIterator.
     */
    private class MyIterator implements Iterator<T> {
        private int current = -1;

        public boolean hasNext() {
            return current + 1 < top;
        }

        public T next() {
            return array[++current];
        }

        public void remove() {
            array[current] = null;
        }
    }
}
