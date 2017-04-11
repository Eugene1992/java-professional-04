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
        private static final int startSize = 16;
        private T[] arr;
        public int top;

        public WriteLinkedList(){
            this.top = 1;
            this.arr = (T[]) new Object[startSize];
        }

        // add - Adds an element to the end of an array

        public T add(T object){
            if (top == arr.length) {
                T[] newArr = (T[]) new Object[(this.arr.length*3)/2 + 1];
                System.arraycopy(this.arr, 0, newArr, 0, this.top);
                this.arr = newArr;
            }
            this.arr[top++] = object;
            return object;
        }
        // add(int index,T object)- inserts the element into the specified position all items on the left are moved to one element

        public T add(int index,T object) throws ArrayIndexOutOfBoundsException{
            if ((index > 0 ) | (index < this.top) ){
                if (top == (arr.length)) {
                    T[] newArr = (T[]) new Object[(this.arr.length*3)/2 + 1];
                    System.arraycopy(this.arr, 0, newArr, 0, this.top);
                    this.arr = newArr;
                }
                for (int numberShear = top; numberShear < index; numberShear--){
                    this.arr[numberShear+1]=this.arr[numberShear];}
                this.arr[index]= object;
                top++;
            }
            else  throw new ArrayIndexOutOfBoundsException();
            return object;

        }

        // get - gives an instance of an element at the specified index

        public T get(int index) throws ArrayIndexOutOfBoundsException{
            if (index > -1 | index <= top ){
                T elem = this.arr[index];
           /* for (int numberShear = index; numberShear < top; numberShear++){
                this.arr[numberShear]=this.arr[numberShear+1];} */
                return elem;
            }
            else  throw new ArrayIndexOutOfBoundsException();
        }

        // set - changes the element in the specified position to the one that is transferred

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
        }
        public int  size(){
            return top;

}
