package com.cbs.edu.vova.arrayDeque;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * My realization of array deque.
 *
 * @param <T> type.
 */
public class MyArrayDeque<T> extends AbstractList implements Iterable {
    private T[] array;
    private int capacity;
    private int first;
    private int last;
    private int amount = 0;

    public MyArrayDeque(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    /**
     * Add element to the start of array.
     *
     * @param value value.
     */
    public void addFirst(T value) {
        if (this.amount == this.array.length) {
            extendArray();
            array[this.amount] = value;
            this.amount += 1;
        } else {
            array[this.amount] = value;
            this.amount += 1;
        }
    }

    /**
     * Add element to the end of array.
     *
     * @param value value.
     */
    public void addLast(T value) {
        if (this.amount == this.array.length) {
            extendArray();
        }
        array[this.amount] = value;
        this.amount += 1;
    }

    /**
     * Method which extend capacity of array by formula: capacity *3 /2 +1.
     */
    private void extendArray() {
        int oldCapacity = this.capacity;
        this.capacity = this.array.length * 3 / 2 + 1;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(this.array, 0, newArray, 0, oldCapacity);
        this.array = newArray;
    }

    public T get(int index) {
        return this.array[index];
    }

    /**
     * Get amount of elements.
     *
     * @return int size.
     */
    public int size() {
        return this.amount;
    }

    public Iterator<T> iterator() {
        return new MyArrayDeque.MyIterator();
    }

    /**
     * Iterator.
     */
    private class MyIterator implements Iterator<T> {
        private int top = -1;

        public boolean hasNext() {
            return top + 1 < amount;
        }

        public T next() {
            return array[++top];
        }

        public void remove() {
            array[top--] = null;
        }
    }
}
