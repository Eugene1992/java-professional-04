package com.cbs.edu.hw_02;

import java.util.Iterator;

/**
 * Custom ArrayList implementation.
 * @param <T> generic type
 */
public class MyArrayList<T> implements Iterable {
    private T[] arr;
    private static final int INITIAL_ARRAY_CAPACITY = 16;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[INITIAL_ARRAY_CAPACITY];
    }


    public void checkException(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**add(T value) Appends the specified element to the end of this list.
     *
     * @param value added object
     * @return If the object is added, return a Boolean value true
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

    /**add(int index, T value) Inserts the specified element at the specified position in this list.
     *
     * @param index specified insert index
     * @param value added object
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public void add(int index, T value) throws IndexOutOfBoundsException {
        checkException(index);
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

    /**remove(int index) Removes the element at the specified position in this list.
     *
     * @param index specified remove object index
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        checkException(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        T elem = arr[--size];
        arr[size] = null;
        return elem;
    }

    /** Gives an instance of an element at the specified index.
     *
     * @param index specified index for retrieved object
     * @return founded object
     * @throws ArrayIndexOutOfBoundsException if specified index is illegal
     */

    public T get(int index) throws IndexOutOfBoundsException {
        checkException(index);
        return arr[index];
    }

    /**Changes the element in the specified position to the one that is transferred.
     *
     * @param index specified updated object index
     * @param value updated object
     * @return updated object
     */
    public T set(int index, T value) throws IndexOutOfBoundsException {
        checkException(index);
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
            for (T tmp : arr) {
                if (tmp.equals(value)) {
                    return true;
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


    /**iterator() Returns an iterator over the elements in this list in proper sequence.
     *
     * @return object Iterator
     */

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




