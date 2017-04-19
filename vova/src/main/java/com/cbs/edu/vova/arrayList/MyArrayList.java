package com.cbs.edu.vova.arrayList;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * My realization of ArrayList.
 */
public class MyArrayList<T> extends AbstractList implements Iterable {
    private int capacity;
    private T[] array;
    private int amount = 0;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    /**
     * Method adding new value to the end of array,
     * if its need array will auto extend.
     *
     * @param value
     */
    public void addValue(T value) {
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
     * Method adding new value to array by index,
     * if its need array will auto extend.
     *
     * @param index
     * @param value
     * @throws IndexOutOfBoundsException
     */
    public void addValue(int index, T value) throws IndexOutOfBoundsException {
        if (index > this.capacity) {
            throw new IndexOutOfBoundsException("Index over array capacity");
        } else {
            if (this.amount >= this.capacity) {
                extendArray();
            }
            T[] fisrtArray = (T[]) new Object[index - 1];
            T[] secondArray = (T[]) new Object[this.capacity - index];
            System.arraycopy(this.array, 0, fisrtArray, 0, index - 1);
            System.arraycopy(this.array, index, secondArray, 0, this.capacity - index);
            System.arraycopy(fisrtArray, 0, this.array, 0, index-1);
            fisrtArray[index] = value;
            this.amount += 1;
            System.arraycopy(secondArray, 0, this.array, index, this.capacity - index);
        }
    }

    /**
     * Method which set value by index.
     *
     * @param index
     * @param value
     * @throws IndexOutOfBoundsException
     */
    public void setValue(int index, T value) throws IndexOutOfBoundsException {
        if (index > this.capacity) {
            throw new IndexOutOfBoundsException("Index over array capacity");
        } else {
            this.array[index] = value;
        }
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

    /**
     * Finding entire value in array and returm its index
     * or -1 if didnt found it.
     *
     * @param value
     * @return
     */
    public int containsValue(T value) {
        for (int i = 0; i < this.amount; i++) {
            if (value == this.array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove value by index.
     *
     * @param index
     */
    public void removeValue(int index) {
        if (index > this.capacity) {
            throw new IndexOutOfBoundsException("Index over array capacity");
        } else {
            T[] fisrtArray = (T[]) new Object[index - 1];
            T[] secondArray = (T[]) new Object[this.capacity - index];
            System.arraycopy(this.array, 0, fisrtArray, 0, index - 1);
            System.arraycopy(this.array, index, secondArray, 0, this.capacity - index);
            System.arraycopy(fisrtArray, 0, this.array, 0, index - 1);
            System.arraycopy(secondArray, 0, this.array, index + 1, this.capacity - index);
            this.amount -= 1;
        }
    }

    /**
     * Get elemnt by index.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return this.array[index];
    }

    /**
     * Method return the number of last element in the array.
     *
     * @return
     */
    public int getLastIndex() {
        return this.amount;
    }

    public int getSize() {
        return capacity;
    }

    public void setSize(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return this.amount;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
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
