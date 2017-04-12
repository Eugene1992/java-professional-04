package com.cbs.edu.lesson_2;

/**
 * Created by Герич on 10.04.2017.
 */

import java.util.Iterator;

/**
 * Write ArrayList implementation, should be realized next methods:
 add(T value)
 add(int index, T value)
 get(int index)
 set(int index, T value)
 contains(T value)
 remove(int index)
 iterator()
 size()
 */
public class MyArrayList<T> implements Iterable{
    private static final int CAPACITY = 16;
    private T[] elements;
    //index переменная, которая показывает в какой индекс добавлять новый елемент
    private int index;
    // size показывает сколько елементов в данный момент
    private int size;

    public MyArrayList() {
        this.elements = (T[]) new Object[CAPACITY];
    }

    //add(T value)-вставляет элемент element в конец списка
    public void add(T value) {
        if (index == elements.length) {
            rost_Array();
        }
        elements[index] = value;
        index++;
        size++;
    }

    private void rost_Array() {
        T[] newArray = (T[]) new Object[(elements.length * 3)/2 + 1];
        System.arraycopy(elements, 0, newArray, 0, index - 1);

        elements = newArray;
    }
        // add(int index, T value)- вставляет элемент element на позицию index
    public boolean add(int index, T value) {
        checkIndex(index);
        if (index == elements.length)
            rost_Array();
        System.arraycopy(elements, index, elements, index + 1, this.index - index);
        elements[index] = value;
        this.index++;
        size++;
        return true;
    }
        // get(int index)- возвращает элемент находящийся на позиции index
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }
   //  set(int index, T value)-возвращает количество элементов всписке.
    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    /**
     * contains(Object o)–возвращает true если список содержит элемент o
     */

    public boolean contains(T value) {
        if (value != null)
            for (T temp : elements) {
                if (temp.equals(value)) {
                    return true;
                }
            }
        return false;
    }
 //   remove(int index)-удаляет элемент по определенной позиции index.
   public T remove(int index){
       checkIndex(index);
       System.arraycopy(elements, index + 1, elements, index, this.index - index);
       size--;
       this.index--;
       return elements[index];
   }
//size()-возвращает количество элементов всписке
   public int size(){
       return size;
   }


    @Override
    public Iterator<T> iterator() {
        return new MyArrayList.MyIterator();
    }
    private class MyIterator implements Iterator<T> {
        int current = -1;

        public boolean hasNext() {
            return current + 1 < index;
        }

        public T next() {
            return elements[++current];
        }

        public void remove() {
            elements[current] = null;
        }
    }
}
