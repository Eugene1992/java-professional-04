package com.cbs.edu.leson;

/**
 * Created with IntelliJ IDEA.
 * User: Волк
 * Date: 13.04.17
 * Time: 22:12
 * To change this template use File | Settings | File Templates.
 */
public class Entry<T>{
        T element;
        Entry<T> next;
        Entry<T> prev;

        Entry(T element, Entry<T> next, Entry<T> prev)
        {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
}
