package com.cbs.edu.leson;

/*@param <T> - Indicates the type of the variable
  Entry - element linkedList
 */
public class Entry<T> {
    T element;
    Entry<T> next;
    Entry<T> prev;

    Entry(T element, Entry<T> next, Entry<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
}
