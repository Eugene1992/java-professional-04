package com.cbs.edu.vladimir.hw_02;


import java.util.Arrays;
import java.util.Iterator;

/**
 * @param <T> tag.
 */
public class MyList<T> implements Iterable<T> {

    private int capacity;
    private int top;
    private T[] array;

    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    /**
     * Add value without index in MyList.
     */
    public void add(T value) {

        if (top == this.array.length) {
            final int enlargement = 3 / 2 + 1;
            int newCapacity = array.length * enlargement;

            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
            newArray[top++] = value;
        } else {
            this.array[top++] = value;
        }
    }

    /**
     * Add value by index in MyList.
     */
    public void addIndex(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("index < 0 | index > array.length ");
        }
        if (index == this.array.length) {
            final int enlargement = (3 / 2 + 1);
            int newCapacity = array.length * enlargement;
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
            newArray[index] = value;
        } else {
            this.array[index] = value;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("index < 0 | index > array.length ");
        }
        return this.array[index];
    }

    public void set(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("index < 0 | index > array.length ");
        }
        this.array[index] = value;
    }

    /**
     * MyList contains.
     */
    public boolean contains(T value) {
        for (int i = 0; i < this.array.length; i++) {
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
        return new MyIterator();
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




