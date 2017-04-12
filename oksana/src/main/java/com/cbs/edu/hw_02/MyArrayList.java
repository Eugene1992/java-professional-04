package com.cbs.edu.hw_02;

import java.util.Iterator;

/**
 * add(T value) Appends the specified element to the end of this list.
 * add(int index, T value) Inserts the specified element at the specified position in this list.
 * get(int index) Returns the element at the specified position in this list.
 * set(int index, T value) Replaces the element at the specified position in this list with the specified element.
 * contains(T value) Returns true if this list contains the specified element.
 * remove(int index) Removes the element at the specified position in this list.
 * iterator() Returns an iterator over the elements in this list in proper sequence.
 * size() Returns the number of elements in this list.
 * countSymbol() Returns map
 *
 * @param <T> generic type
 */
public class MyArrayList<T> implements Iterable {
    private T[] arr;
    private static final int INITIAL_ARRAY_CAPACITY = 16;
    private int size;
    private String str;

    public MyArrayList() {
        arr = (T[]) new Object[INITIAL_ARRAY_CAPACITY];
        str = "Hello, Java";
    }

    /**
     * Adds an element to the end of an array.
     *
     * @param value added object
     * @return logical operation result
     */
    public boolean add(T value) {
        if (size == arr.length) {
            final int newSize = arr.length * 3 / 2 + 1;
            T[] newArr = (T[]) new Object[newSize];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            this.arr = newArr;
        }
        arr[size++] = value;
        return true;
    }

    /**
     * Inserts the element into the specified position all items on the left are moved to one element.
     *
     * @param index specified insert index
     * @param value added object
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public void add(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) {
            final int newSize = arr.length * 3 / 2 + 1;
            T[] newArr = (T[]) new Object[newSize];
            System.arraycopy(arr, 0, newArr, 0, size);
            this.arr = newArr;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    /**
     * Removes the specified object and all elements that are "to the right" are moved one cell to the left.
     *
     * @param index specified remove object index
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        T elem = arr[--size];
        arr[size] = null;
        return elem;
    }

    /**
     * Gives an instance of an element at the specified index.
     *
     * @param index specified index for retrieved object
     * @return founded object
     * @throws ArrayIndexOutOfBoundsException if specified index is illegal
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * Changes the element in the specified position to the one that is transferred.
     *
     * @param index specified updated object index
     * @param value updated object
     * @return updated object
     */
    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = value;
        return arr[index];
    }

    /**
     * Determines the presence of at least some values.
     *
     * @param value specified object
     * @return comparing result
     */
    public boolean contains(T value) {
        if (value != null) {
            for (T tmp : arr) {
                if (tmp.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns list size.
     *
     * @return list size
     */
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayList.MyIterator();
    }

    /**
     * Iterator implementation.
     */
    private class MyIterator implements Iterator<T> {
        private int current = -1;

        public boolean hasNext() {
            return current + 1 < size;
        }

        public T next() {
            return arr[++current];
        }

        public void remove() {
            arr[current] = null;
        }
    }
}




