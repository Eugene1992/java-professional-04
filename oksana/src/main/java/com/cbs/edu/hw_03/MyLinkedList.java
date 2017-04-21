package com.cbs.edu.hw_03;


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

    /**
     * Custom Node implementation.
     *
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

    public void checkIndexOutOfBoundsException(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Appends the specified element to the end of this list.
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

    /**
     * Appends the specified element to the top of this list.
     *
     * @param element added object in the beginning
     * @return If the object is added, return a Boolean value true
     */
    public boolean addFirst(T element) {
        Node<T> prevObject = this.head;
        Node<T> nextObject = new Node<>(null, element, prevObject);
        this.head = nextObject;
        if (prevObject == null) {
            this.tail = nextObject;
        } else {
            prevObject.prev = nextObject;
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   specified insert index
     * @param element added object
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public void addByIndex(int index, T element) throws IndexOutOfBoundsException {
        checkIndexOutOfBoundsException(index);
        Node<T> nextObject = head;
        for (int i = index; i > 0; i--) {
            nextObject = nextObject.next;
        }
        if (index == 0) {
            addFirst(element);
        }
        Node<T> prevObject = nextObject.prev;
        Node<T> currentObject = new Node<T>(prevObject, element, nextObject);
        prevObject.next = currentObject;
        nextObject.prev = currentObject;
        size++;
    }

    /**
     * Determines the presence of at least some values.
     *
     * @param value specified object
     * @return comparing result
     */
    public boolean contains(T value) {
        Node<T> nextObject = this.head;
        for (int i = 0; i <= size - 1; i++) {
            if (nextObject.element.equals(value)) {
                return true;
            }
            nextObject = nextObject.next;
        }
        return false;
    }

    /**
     * Changes the element in the specified position to the one that is transferred.
     *
     * @param index specified updated object index
     * @param value updated object
     * @return updated object
     */
    public T set(int index, T value) throws IndexOutOfBoundsException {
        checkIndexOutOfBoundsException(index);
        Node<T> nextObject = head;
        if (index == 0) {
            nextObject.element = value;
            return nextObject.element;
        } else {
            for (int i = index; i > 0; i--) {
                nextObject = nextObject.next;
            }
            nextObject.next.element = value;
            return nextObject.next.element;
        }
    }

    /**
     * remove(int index) Removes the element at the specified position in this list.
     *
     * @param index specified remove object index
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        checkIndexOutOfBoundsException(index);
        Node<T> nextObject = head;
        T element = null;
        if (index == 0) {
            element = nextObject.element;
            head = nextObject.next;
        } else {
            for (int i = index; i > 0; i--) {
                nextObject = nextObject.next;
            }
            element = nextObject.next.element;
            nextObject.next.element = null;
        }
        size--;
        return element;
    }

    /**
     * Gives an instance of an element at the specified index.
     *
     * @param index specified index for retrieved object
     * @return founded object
     * @throws IndexOutOfBoundsException if specified index is illegal
     */
    public T get(int index) throws IndexOutOfBoundsException {
        checkIndexOutOfBoundsException(index);
        Node<T> nextObject = head;
        if (index == 0) {
            return nextObject.element;
        } else {
            for (int i = index; i > 0; i--) {
                nextObject = nextObject.next;
            }
            return nextObject.next.element;
        }
    }

    /**
     * Returns list size.
     *
     * @return list size
     */
    public int size() {
        return size;
    }

    /**
     * iterator() Returns an iterator over the elements in this list in proper sequence.
     *
     * @return object Iterator
     */
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Iterator implementation.
     */
    private class MyIterator implements Iterator<T> {
        private int current = -1;
        private Node<T> currentObject = null;

        /**
         * Returns true if the iteration has more elements.
         *
         */
        public boolean hasNext() {
            return current + 1 < size;
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return object T
         */
        public T next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                if (currentObject == null) {
                    currentObject = head;
                } else {
                    currentObject = currentObject.next;
                }
                ++this.current;
                return currentObject.element;
            }
        }
    }
}





