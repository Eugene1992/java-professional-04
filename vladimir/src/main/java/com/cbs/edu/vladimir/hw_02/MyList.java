package com.cbs.edu.vladimir.hw_02;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Vladimir on 12.04.2017.
 */
public class MyList<T> implements Iterable<T> {

    private int capacity;
    private int top;
    private T[] array;

    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public void add(T value) {

        if (top == this.array.length) {

            int newCapacity = array.length * 3 / 2 + 1;
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
            newArray[top++] = value;

        } else {
            this.array[top++] = value;
        }
    }


    public void addIndex(int index, T value) {
        if (index == this.array.length) {

            int newCapacity = array.length * 3 / 2 + 1;
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
            newArray[index] = value;
        } else {
            this.array[index] = value;
        }
    }

    public T get(int index) {
        return this.array[index + 1];
    }

    public void set(int index, T value) {
        this.array[index] = value;
    }

    public boolean contains(T value) {

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) return true;
        }
        return false;
    }

    public void remove(int index) {
        this.array[index] = null;
    }

    public int size() {
        int x = 0;
        for (int i = 0; i <= this.array.length; i++) {
            x = i;
        }
        return x;
    }


    @Override
    public String toString() {
        return "MyList{" +
                "array=" + Arrays.toString(array) +
                ", capacity=" + capacity +
                ", top=" + top +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class myIterator implements Iterator {


        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }

        public void remove() {

        }
    }
}


