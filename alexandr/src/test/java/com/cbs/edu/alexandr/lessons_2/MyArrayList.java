package com.cbs.edu.alexandr.lessons_2;

/**
 * Created by Герич on 10.04.2017.
 */

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
public class MyArrayList<T> {
    private static final int CAPACITY = 16;
    private T[] elements;
    private int index;
    private int size;

    //   ArrayList<Integer> arrayList = new ArrayList<>();

    public MyArrayList() {
        this.elements = (T[]) new Object[CAPACITY];
    }

    public void add(T value) {
        if (index == elements.length) {
            rost_Array();
        }
        elements[index] = value;
        index++;
        size++;
    }

    private void rost_Array() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);

        elements = newArray;
    }

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

    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }

    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    /**
     * contains(Object o)–возвращает true если список содержит элемент o
     */

    public boolean contains(T value) {
        checkIndex(index);

        for (int i = 0; i < size; i++) {

//            if () {
//
//            } else
//
//
//        }
        }
        return true;
    }

 //       думаю



   public T remove(int index){
       checkIndex(index);
       System.arraycopy(elements, index + 1, elements, index, this.index - index);
       size--;
       this.index--;
       return elements[index];
   }

   public int size(){
       return size;
   }


}
