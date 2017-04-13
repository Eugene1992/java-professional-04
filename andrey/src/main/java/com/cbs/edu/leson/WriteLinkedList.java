package com.cbs.edu.leson;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Волк
 * Date: 11.04.17
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class WriteLinkedList<T> implements Iterable<T> {
    private int size;
    private Entry<T> header;

    public WriteLinkedList(){
        header= new Entry<T>(null,header,header);
        size = 0;
    }
        // add - Adds an element to the end of an array
        public void add(T object){
            Entry<T> newEntry = new Entry<T>(object, header, header.prev);
        newEntry.prev.next = newEntry;
        newEntry.next.prev = newEntry;
        size++;
        }
        // add(int index,T object)- inserts the element into the specified position all items on the left are moved to one element
        public T add(int index,T object) throws ArrayIndexOutOfBoundsException{
            if ((index > 0 ) | (index < this.size) ){
                if (index> (size/2)) {
                Entry position = header.prev;
                    for (int numberShear = size; numberShear < index; numberShear--){
                    position = position.prev;
                    }
                Entry<T> newEntry = new Entry<T>(object, position, position.prev);
                   position.prev=newEntry;
                }
                else {Entry position = header.next;
                    for (int numberShear = 0; numberShear < index; numberShear++){
                    position = position.next;
                    }
                Entry<T> newEntry = new Entry<T>(object, position.next, position);
                     position.next=newEntry;
                }
                    size++;
            }
            else  throw new ArrayIndexOutOfBoundsException();
            return object;
        }

        // get - gives an instance of an element at the specified index

        public T get(int index) throws ArrayIndexOutOfBoundsException{
            if (index > 0 | index <size ){
                Entry position;
                if (index> (size/2)) {
                    position = header.prev;
                    for (int numberShear = size; numberShear < index; numberShear--){
                    position = position.prev;
                    }
                }
                else {
                        position = header.next;
                    for (int numberShear = 0; numberShear < index; numberShear++){
                        position = position.next;}
                    }

              return  (T)position.element;
            }
            else  throw new ArrayIndexOutOfBoundsException();
            }

   /*     // set - changes the element in the specified position to the one that is transferred

        public T set(int index,T object)throws ArrayIndexOutOfBoundsException{
            if (index > 0 | index<=top ){
                this.arr[index]= object;
                return object;
            }
            else  throw new ArrayIndexOutOfBoundsException();

        }

        //contains - determines the presence of at least some values

        public boolean contains(T object){
            boolean bul= false;
            for (int number = 1; number < top; number++){
                if (this.arr[number] != null){
                    bul=true;
                } else bul=false;
            }    return bul;
        }

        //  remove - removes the specified object and all elements that are "to the right" are moved one cell to the left

        public void remove(int index)throws ArrayIndexOutOfBoundsException{
            if (index >= 0 | index<top ){
                for (int numberShear = index; numberShear < top; numberShear++){
                    this.arr[numberShear]=this.arr[numberShear+1];}
                this.arr[top]= null;
                top--;
            }     else  throw new ArrayIndexOutOfBoundsException();
        }
        @Override
        public Iterator<T> iterator(){
            return new MyIterator();
        }
        private class MyIterator implements Iterator<T> {
            int current = -1;

            public boolean hasNext() {
                return current + 1 < top;
            }

            public T next() {
                return arr[++current];
            }

            public void remove() {
                arr[current] = null;
            }
        } */
        public int  size(){
            return size;
        }
}
