package com.cbs.edu.leson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WriteLinkedListTest {
    private WriteLinkedList<Integer> writeLinkedList;
    private Integer value1;
    private Integer value2;
    private Integer value3;


    @Before
    public void setUp() {
        writeLinkedList = new WriteLinkedList<>();
        value1 = 2;
        value2 = 5;
        value3 = 3;
    }

   /* @Test
    public void addTest1PlusGetTest() {
        Assert.assertEquals(writeLinkedList.add(value2));
        /*writeLinkedList.add(value1);
        writeLinkedList.add(value2);
       writeLinkedList.add(1,value3);
        Integer element = writeLinkedList.get(1);
        Assert.assertEquals(value3, element);

    }    */

    //как написать тест для метода add(int index, T value), если он ничего не возвращает
    @Test
    public void addTest2() {


    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndex() {
        writeLinkedList.add(-5, value1);
    }

    //как написать тест, если не использовать метод add???
    @Test
    public void removeTest() {
        writeLinkedList.add(value1);
        writeLinkedList.add(value2);
        writeLinkedList.add(1, value3);
        writeLinkedList.remove(1);
        Integer element = writeLinkedList.get(1);
        Assert.assertEquals(value2, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWrongIndex() {
        writeLinkedList.add(value1);
        writeLinkedList.remove(-5);
    }

    @Test
    public void containsTest() {
        writeLinkedList.add(value1);
        writeLinkedList.add(value2);
        Assert.assertTrue(writeLinkedList.contains(value2));
    }

    @Test
    public void setTest() {
        writeLinkedList.add(value1);
        writeLinkedList.add(value2);
        Integer element = writeLinkedList.set(0, value3);
        Assert.assertEquals(value3, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWrongIndex() {
        final int unexpectedIndex = -3;
        writeLinkedList.set(unexpectedIndex, value3);
    }

    @Test
    public void sizeTest() {
        final int expectedSize = 5;
        for (int i = 0; i < expectedSize; i++) {
            writeLinkedList.add(value2);
        }
        final int actualSize = writeLinkedList.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void iteratorTest() {
        Assert.assertNotNull(writeLinkedList.iterator());
    }

    @Test
    public void hasNextTest() {
        writeLinkedList.add(value1);
        Assert.assertTrue(writeLinkedList.iterator().hasNext());
    }

    @Test
    public void nextTest() {
        writeLinkedList.add(value1);
        Assert.assertNotNull(writeLinkedList.iterator().next());
        Integer element = writeLinkedList.iterator().next();
        Assert.assertEquals(value1, element);
    }
}