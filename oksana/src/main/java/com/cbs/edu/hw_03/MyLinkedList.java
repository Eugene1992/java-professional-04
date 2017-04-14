package com.cbs.edu.hw_03;

import com.cbs.edu.hw_02.MyArrayList;

import java.util.*;
/**
 * Custom MyLinkedList implementation.
 * @param <T> generic type
 */
public class MyLinkedList<T> {
    private Node tail;
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }
    // public MyLinkedList() {
     //   size = 0;
    //}

    /**
     * Custom Node implementation.
     * @param <T> generic type
     */
    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void checkException(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**Appends the specified element to the end of this list.
     *
     * @param element added object in the end
     * @return If the object is added, return a Boolean value true
     */
    public boolean addLast(T element) {
         Node<T> prevObject = this.tail;
        Node<T> nextObject = new Node<T>(prevObject, element, (Node<T>) null);
        this.tail = nextObject;
        if (prevObject == null) {
            this.head = nextObject;
        } else {
            prevObject.next = nextObject;
        }
        size++;
        return true;
    }
    /**add(int index, T value) Inserts the specified element at the specified position in this list.
     *
     * @param index specified insert index
     * @param element added object
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public void addIndex(int index, T element) throws IndexOutOfBoundsException {
        checkException(index);
        Node<T> nextObject= head;
        while(--index > 0){
            nextObject = nextObject.next;
        }
        Node<T> prevObject= nextObject.prev;
        Node<T> currentObject = new Node<T>(prevObject, element, nextObject);
        prevObject.next = currentObject;
        nextObject.prev = currentObject;
        size++;
    }
    //@Override
    public Iterator<T> iterator() {
        return new MyLinkedList.MyIterator();
    }

    /**
     * Iterator implementation.
     */
    private class MyIterator implements Iterator<T> {
        private int current = -1;
        MyLinkedList.Node<T> tail;
        MyLinkedList.Node<T> head = getHead();
        //private Node head;

        public boolean hasNext() {
            return current + 1 < size;
        }

        public T next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                this.head = this.tail;
                this.tail = this.tail.next;
                ++this.current;
                return this.head.element;
            }
        }
    }



}
