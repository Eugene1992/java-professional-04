package homework.hw02;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created by dimon on 10.04.2017.
 */
public class ArrayStack<T> implements Iterable<T> {

    T[] stackArray;
    int stackCapacity = 16;
    int stackTop = 0;

    public void ArrayStackCreate() {
        stackArray = (T[]) new Object[stackCapacity];
    }

    /**
     * add input value to ArrayList
     *
     * @param value
     */
    void add(T value) {
        if (stackTop > stackCapacity) {
            stackArrayUpdateCapasity();
        }
        stackArray[stackTop++] = value;
    }

    /**
     * add input value to index ArrayList
     *
     * @param value Input value
     * @param index Index add arrayList
     * @return
     */
    public T add(T value, int index) {
        if (index >= 0 | index < stackTop) {
            if (stackTop > stackCapacity)
                stackArrayUpdateCapasity();
            for (int shear = stackTop; shear < index; shear--) {
                stackArray[shear + 1] = stackArray[shear];
            }
            stackArray[index] = value;
            stackTop++;
        } else throw new EmptyStackException();
        return value;
    }

    /**
     * get value from index and delete it from list
     *
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        T returnStackIndexValue;
        if (indexChecker(index)) {
            T[] stackArrayCopy = (T[]) new Object[(stackCapacity * 3) / 2 + 1];
            stackArrayCopy = stackArray.clone();
            returnStackIndexValue = stackArray[index];
        } else throw new EmptyStackException();
        return returnStackIndexValue;
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (indexChecker(index)) {
            stackArray[index] = null;
        }
    }

    public boolean contains(T object) {
        int containsObjects = 0;
        for (int arrayIndex = 0; arrayIndex < stackArray.length; arrayIndex++) {
            if (stackArray[arrayIndex] == object)
                containsObjects++;
        }
        if (containsObjects > 0) {
            return true;
        } else return false;
    }

    /**
     * set value to index in stackArray
     *
     * @param index
     * @param value
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public T set(int index, T value) throws ArrayIndexOutOfBoundsException {
        if (indexChecker(index)) {
            stackArray[index] = value;
            return value;
        } else throw new ArrayIndexOutOfBoundsException();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Create buffer array to copy array
     * Update stackArray size
     * Copy from buffer information to stackArray
     */
    void stackArrayUpdateCapasity() {
        T[] stackArrayCopy = (T[]) new Object[(stackCapacity * 3) / 2 + 1];
        stackArrayCopy = stackArray.clone();
        stackArray = stackArrayCopy;
    }

    public boolean indexChecker(int index) {
        if (index >= 0 | index < stackTop) ;
        return true;
    }

    public Iterator<T> iterator() {
        return (Iterator<T>) new MyIterator();
    }

    private class MyIterator implements Iterable<T> {
        int current = -1;

        public boolean hasNext() {
            return current + 1 < stackTop;
        }

        public T next() {
            return stackArray[++current];
        }

        public void remove() {
            stackArray[current] = null;
        }

        public int size() {
            return stackTop;
        }

        public Iterator<T> iterator() {
            return null;
        }
    }


}


