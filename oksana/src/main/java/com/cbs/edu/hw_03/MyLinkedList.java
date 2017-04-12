package com.cbs.edu.hw_03;

import java.util.*;

public class MyLinkedList<T> {

    private Node tail;
    private Node head;
    private int size;

    private static class Node<T>
    {
        T element;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next)
        {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

    }

    public boolean add(T element) {
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


}
