package com.cbs.edu.examples.solutions;

import java.util.Iterator;

public interface MyList<E> {

    boolean add(E value);

    void add(int index, E value);

    E get(int index);

    E set(int index, E value);

    boolean contains(E value);

    E remove(int index);

    int size();

    Iterator<E> iterator();
}
