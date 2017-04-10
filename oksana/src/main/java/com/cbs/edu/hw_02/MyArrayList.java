package com.cbs.edu.hw_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
 * @param <T>
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


    public boolean add(T value) {
        if (size == arr.length) {
            T[] newArr = (T[]) new Object[arr.length * 3 / 2 + 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            this.arr = newArr;
        }
        arr[size++] = value;
        return true;
    }

    public void add(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (size == arr.length) {
            T[] newArr = (T[]) new Object[arr.length * 3 / 2 + 1];
            System.arraycopy(arr, 0, newArr, 0, size);
            this.arr = newArr;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        T elem = arr[--size];
        arr[size] = null;
        return elem;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return arr[index] = value;
    }

    public boolean contains(T value) {
        if (value != null) {
            for (T tmp : arr) {
                if (tmp.equals(value))
                    return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    Map<String, Integer> countSymbol() {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put(str, count);
        return map;
    }


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




