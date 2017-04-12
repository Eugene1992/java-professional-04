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

        Node(T element, Node<T> next, Node<T> prev)
        {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        Node(){}
    }

    public boolean add(T element){
        Node<T> object = new Node<T>();
        object.element = element;
        object.next = null;
        object.prev = tail;
        tail.next = object;
        size++;

        return true;
    }

    public void add(int index, T element){
        Node<T> object = new Node<T>();
        object.element = element;
        for(int i = 0; i < size; i++){
            if(i == index) object.next = Node<Е>
        }

        object.prev = tail;

        size++;
    }


}
