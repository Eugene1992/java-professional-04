/**
 dd(T value) - Adds an element to the end of an array
 • add(int index, T value) - inserts the element into the specified position all items on the left are moved to one element
 • get(int index) gives an instance of an element at the specified index
 • set(int index, T value) - changes the element in the specified position to the one that is transferred
 • contains(T value)  -  determines the presence of at least some values
 • remove(int index) - removes the specified object and all elements that are "to the right" are moved one cell to the left
 • iterator()
 */
package com.cbs.edu.leson;

import java.util.Iterator;

public class WriteLinkedList<T> implements Iterable<T> {
    private int size;
    private Entry<T> header;

    public WriteLinkedList() {
        header = new Entry<T>(null, header, header);
        size = 0;
    }

    // add - Adds an element to the end of an array
    public T add(T object) {
        Entry<T> newEntry = new Entry<T>(object, header, header.prev);
        if (size == 0) {
            header.next = newEntry;
            header.prev = newEntry;
        } else {
            newEntry.prev.next = newEntry;
            newEntry.next.prev = newEntry;
        }
        size++;
        return object;
    }

    // add(int index,T object)- inserts the element into the specified position all items on the left are moved to one element
    public T add(int index, T object) throws ArrayIndexOutOfBoundsException {
        if ((index > 0) | (index < this.size)) {
            if (index > (size / 2)) {
                Entry position = header.prev;
                for (int numberShear = size; numberShear < index; numberShear--) {
                    position = position.prev;
                }
                Entry<T> newEntry = new Entry<T>(object, position, position.prev);
                position.prev.next = newEntry;
                position.prev = newEntry;
            } else {
                Entry position = header.next;
                for (int numberShear = 0; numberShear < index; numberShear++) {
                    position = position.next;
                }
                Entry<T> newEntry = new Entry<T>(object, position, position.prev);
                position.prev.next = newEntry;
                position.prev = newEntry;
            }
            size++;
        } else throw new ArrayIndexOutOfBoundsException();
        return object;
    }

    // get - gives an instance of an element at the specified index
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index > 0 | index < size) {
            Entry position;
            if (index > (size / 2)) {
                position = header.prev;
                for (int numberShear = size; numberShear < index; numberShear--) {
                    position = position.prev;
                }
            } else {
                position = header.next;
                for (int numberShear = 0; numberShear < index; numberShear++) {
                    position = position.next;
                }
            }

            return (T) position.element;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    // set - changes the element in the specified position to the one that is transferred
    public T set(int index, T object) throws ArrayIndexOutOfBoundsException {
        if (index > 0 | index < size) {
            Entry position;
            if (index > (size / 2)) {
                position = header.prev;
                for (int numberShear = size; numberShear < index; numberShear--) {
                    position = position.prev;
                }
            } else {
                position = header.next;
                for (int numberShear = 0; numberShear < index; numberShear++) {
                    position = position.next;
                }
            }
            position.element = object;
            return (T) position.element;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    //contains - method determines whether there is a given element in the link list
    public boolean contains(T object) {
        boolean bul = false;
        Entry position = header;
        for (int number = 0; number < size; number++) {
            if (position.element == object)
                return bul = true;
            else position = position.next;
        }
        return bul;
    }

    //  remove - gives the specified object
    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index > 0 | index < size) {
            Entry position;
            if (index > (size / 2)) {
                position = header.prev;
                for (int numberShear = size; numberShear < index; numberShear--) {
                    position = position.prev;
                }
            } else {
                position = header.next;
                for (int numberShear = 0; numberShear < index; numberShear++) {
                    position = position.next;
                }
            }
            position.next.prev = position.prev;
            position.prev.next = position.next;
            size--;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        Entry position = header;

        public boolean hasNext() {
            return position.next != header;
        }

        public T next() {
            position = position.next;
            return (T) position.element;
        }

        public void remove() {
            position.next.prev = position.prev;
            position.prev.next = position.next;
            size--;
            position = position.next;
        }
    }

    public int size() {
        return size;
    }
}
