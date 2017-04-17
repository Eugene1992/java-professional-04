package com.cbs.edu.examples.solutions;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    public MyLinkedList() {
        first.next = last;
        first.prev = last;
        last.next = first;
        last.prev = first;
    }

    @Override
    public boolean add(E value) {
        Node<E> tmpNode;
        if (size == 0) {
            tmpNode = new Node<>(first, value, last);
            first.next = tmpNode;
        }

        return false;
    }

    @Override
    public void add(int index, E value) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E value) {
        return null;
    }

    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
