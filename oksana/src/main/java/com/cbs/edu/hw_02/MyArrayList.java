package com.cbs.edu.hw_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyArrayList<T> implements Iterable {
    private T[] arr;
    private static final int INITIAL_ARRAY_CAPACITY = 16;
    private int size;
    private String str;

    public MyArrayList() {

        arr = (T[]) new Object[INITIAL_ARRAY_CAPACITY];
        str = "Hello, Java";
    }


    public void checkException(int index) throws IndexOutOfBoundsException{
        if (index < 0 | index >= size)
            throw new IndexOutOfBoundsException();
    }

    /**add(T value) Appends the specified element to the end of this list.
     *
     * @param value
     * @return
     */
    public boolean add(T value) {
        if (size == arr.length) {
            T[] newArr = (T[]) new Object[arr.length * 3 / 2 + 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            this.arr = newArr;
        }
        arr[size++] = value;
        return true;
    }

    /**add(int index, T value) Inserts the specified element at the specified position in this list.
     *
     * @param index
     * @param value
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, T value) throws IndexOutOfBoundsException {
        checkException(index);
        if (size == arr.length) {
            T[] newArr = (T[]) new Object[arr.length * 3 / 2 + 1];
            System.arraycopy(arr, 0, newArr, 0, size);
            this.arr = newArr;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    /**remove(int index) Removes the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        checkException(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        T elem = arr[--size];
        arr[size] = null;
        return elem;
    }

    /**get(int index) Returns the element at the specified position in this list.
     *
     * @param index
     * @return
     */
    public T get(int index) throws IndexOutOfBoundsException{
        checkException(index);
        return arr[index];
    }

    /**set(int index, T value) Replaces the element at the specified position in this list with the specified element.
     *
     * @param index
     * @param value
     * @return
     */
    public T set(int index, T value) throws IndexOutOfBoundsException {
        checkException(index);
        return arr[index] = value;
    }

    /**contains(T value) Returns true if this list contains the specified element.
     *
     * @param value
     * @return
     */
    public boolean contains(T value) {
            for (T tmp : arr) {
                if (tmp.equals(value))
                    return true;
            }
        return false;
    }

    /**size() Returns the number of elements in this list.
     *
     * @return
     */
    public int size() {
        return size;
    }


    /**iterator() Returns an iterator over the elements in this list in proper sequence.
     *
     * @return Iterator<T>
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayList.MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int current = -1;

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




