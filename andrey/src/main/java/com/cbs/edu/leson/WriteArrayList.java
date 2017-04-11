package com.cbs.edu.leson;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * • add(T value) - Adds an element to the end of an array
 * • add(int index, T value) - inserts the element into the specified position all items on the left are moved to one element
 * • get(int index) gives an instance of an element at the specified index
 * • set(int index, T value) - changes the element in the specified position to the one that is transferred
 * • contains(T value)  -  determines the presence of at least some values
 * • remove(int index) - removes the specified object and all elements that are "to the right" are moved one cell to the left
 * • iterator()
 * • size()
 */
public class WriteArrayList<T> implements Iterable<T> {

    private static final int startSize = 1;
    private T[] arr;
    public int top;

    public WriteArrayList() {
        this.top = 0;
        this.arr = (T[]) new Object[startSize];
    }

    // add - Adds an element to the end of an array

    public T add(T object) {
        if (top == arr.length) {
            T[] newArr = (T[]) new Object[(this.arr.length * 3) / 2 + 1];
            System.arraycopy(this.arr, 0, newArr, 0, this.top);
            this.arr = newArr;
        }
        this.arr[top++] = object;
        return object;
    }
    // add(int index,T object)- inserts the element into the specified position all items on the left are moved to one element

    public T add(int index, T object) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index < top) {
            if (top == arr.length) {
                T[] newArr = (T[]) new Object[(this.arr.length * 3) / 2 + 1];
                System.arraycopy(this.arr, 0, newArr, 0, this.top);
                this.arr = newArr;
            }
            for (int numberShear = top; numberShear < index; numberShear--) {
                this.arr[numberShear + 1] = this.arr[numberShear];
            }
            this.arr[index] = object;
            top++;
        } else throw new EmptyStackException();
        return object;

    }

    // get - gives an instance of an element at the specified index

    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index <= top) {
            T elem = this.arr[index];
           /* for (int numberShear = index; numberShear < top; numberShear++){
                this.arr[numberShear]=this.arr[numberShear+1];} */
            return elem;
        } else throw new EmptyStackException();
    }

    // set - changes the element in the specified position to the one that is transferred

    public T set(int index, T object) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index <= top) {
            this.arr[index] = object;
            return object;
        } else throw new EmptyStackException();
    }

    //contains - determines the presence of at least some values

    public boolean contains(T object) {
        for (int number = 0; number < top; number++) {
            if (this.arr[number].equals(object)) return true;
        }
        return false;
    }

    //  remove - removes the specified object and all elements that are "to the right" are moved one cell to the left

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index < top) {
            for (int numberShear = index; numberShear < top; numberShear++) {
                this.arr[numberShear] = this.arr[numberShear + 1];
            }
            this.arr[top] = null;
            top--;
        } else throw new EmptyStackException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int current = -1;

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

    //  public Map<int,T>   givemap(T objact){
    //     Map<String, T> staff = new HashMap<String, T>();
    //     for (int number =0 ; number < top; number++){
    //        map.put(number,this.arr[number]}
    //  }


}
