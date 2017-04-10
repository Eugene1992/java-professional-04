package homework.hw01;

import java.util.EmptyStackException;
import java.util.Iterator;


/**
 * Created by dimon on 10.04.2017.
 */
public class ArrayStack<T> implements Iterable<T> {

    private T[] stackArray;
    public int top = 0;

    public ArrayStack() {
        this.stackArray = (T[]) new Object[1];
    }

    /**
     * @param object
     * @return
     */
    public T add(T object) {
        if (top == stackArray.length) {
            T[] ArrayStackCopy = (T[]) new Object[(this.stackArray.length * 3) / 2 + 1];
            System.arraycopy(this.stackArray, 0, ArrayStackCopy, 0, top);
            this.stackArray = ArrayStackCopy;
        }
        this.stackArray[top++] = object;
        return object;
    }

    /**
     *
     * @param index
     * @param object
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public T add(int index, T object) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index < top) {
            if (top == stackArray.length) {
                T[] ArrayStackCopy = (T[]) new Object[(this.stackArray.length * 3) / 2 + 1];
                System.arraycopy(this.stackArray, 0, ArrayStackCopy, 0, top);
                this.stackArray = ArrayStackCopy;
            }
            for (int num = top; num < index; num--) {
                this.stackArray[num + 1] = this.stackArray[num];
            }

            this.stackArray[index] = object;
            top++;
        } else throw new EmptyStackException();
        return object;
    }

    /**
     *
     * @param index
     * @param object
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public T set(int index, T object) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 | index <= top) {
            this.stackArray[index] = object;
            return object;
        } else throw new EmptyStackException();
    }


    public Iterator<T> iterator() {
        return (Iterator<T>) new MyIterator();
    }



    private class MyIterator implements Iterable<T> {
        int current  =-1;

        public boolean hasNext() {
            return current + 1 < top;
        }

        public T next() {
            return stackArray[++current];
        }

        public void remove() {
            stackArray[current] = null;
        }

        public Iterator<T> iterator() {
            return null;
        }
    }

    public int size() {
        return top;
    }
}


