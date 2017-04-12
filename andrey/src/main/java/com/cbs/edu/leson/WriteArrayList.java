package com.cbs.edu.leson;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Custom ArrayList implementation.
 * @param <T> genetic type
 */
public class WriteArrayList<T> implements Iterable<T> {
    private static final int START_SIZE = 1;
    private T[] arr;
    private int top;

    public WriteArrayList() {
        this.top = 1;
        this.arr = (T[]) new Object[START_SIZE];
    }

    /**
     * Adds an element to the end of an array.
     *
     * @param object added object
     * @return saved object
     */
    public T add(T object) {
        if (top == arr.length) {
            final int newSize = (this.arr.length * 3) / 2 + 1;
            T[] newArr = (T[]) new Object[newSize];
            System.arraycopy(this.arr, 0, newArr, 0, this.top);
            this.arr = newArr;
        }
        this.arr[top++] = object;
        return object;
    }

    /**
     * Inserts the element into the specified position all items on the left are moved to one element.
     *
     * @param index specified insert index
     * @param object added object
     * @return saved object
     * @throws ArrayIndexOutOfBoundsException if specified index is illegal
     */
    public T add(int index, T object) throws ArrayIndexOutOfBoundsException {
        if ((index > 0) | (index < this.top)) {
            if (top == (arr.length)) {
                final int newSize = (this.arr.length * 3) / 2 + 1;
                T[] newArr = (T[]) new Object[newSize];
                System.arraycopy(this.arr, 0, newArr, 0, this.top);
                this.arr = newArr;
            }
            for (int numberShear = top; numberShear < index; numberShear--) {
                this.arr[numberShear + 1] = this.arr[numberShear];
            }
            this.arr[index] = object;
            top++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return object;
    }

    /**
     * Gives an instance of an element at the specified index.
     *
     * @param index specified index for retrieved object
     * @return founded object
     * @throws ArrayIndexOutOfBoundsException if specified index is illegal
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index > 0 | index <= top) {
            T elem = this.arr[index];
            return elem;
        } else {
            throw new EmptyStackException();
        }
    }

    /**
     * Changes the element in the specified position to the one that is transferred.
     *
     * @param index specified updated object index
     * @param object updated object
     * @return updated object
     * @throws ArrayIndexOutOfBoundsException if specified index is illegal
     */
    public T set(int index, T object) throws ArrayIndexOutOfBoundsException {
        if (index > 0 | index <= top) {
            this.arr[index] = object;
            return object;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Determines the presence of at least some values.
     *
     * @param object specified object
     * @return comparing result
     */
    public boolean contains(T object) {
        boolean bul = false;
        for (int number = 1; number < top; number++) {
            if (this.arr[number] != null) {
                bul = true;
            } else {
                bul = false;
            }
        }
        return bul;
    }

    /**
     * Removes the specified object and all elements that are "to the right" are moved one cell to the left.
     *
     * @param index specified remove object index
     * @throws ArrayIndexOutOfBoundsException if specified index is illegal
     */
    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index < top) {
            for (int numberShear = index; numberShear < top; numberShear++) {
                this.arr[numberShear] = this.arr[numberShear + 1];
            }
            this.arr[top] = null;
            top--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Iterator implementation.
     */
    private class MyIterator implements Iterator<T> {
        private int current = -1;

        public boolean hasNext() {
            return current + 1 < top;
        }

        public T next() {
            return arr[++current];
        }

        public void remove() {
            arr[current] = null;
        }
    }

    public int size() {
        return top;
    }
}
