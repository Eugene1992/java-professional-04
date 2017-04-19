package com.cbs.edu.vova.arrayDeque;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * Created by DarKnight on 019 19.04.17.
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

    public int size() {
        return this.amount;
    }

    public Iterator<T> iterator() {
        return new MyArrayDeque.MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int top = -1;

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
