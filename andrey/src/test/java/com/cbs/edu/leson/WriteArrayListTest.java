package com.cbs.edu.leson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WriteArrayListTest {
    private WriteArrayList<Integer> writeArrayList;
    private Integer value1;
    private Integer value2;
    private Integer value3;


    @Before
    public void setUp() {
        writeArrayList = new WriteArrayList<>();
        value1 = 45;
        value2 = 50;
        value3 = 3;
    }

    @Test
    public void addTest1PlusGetTest() {

        Assert.assertEquals(true, writeArrayList.add(value2));
        /*writeArrayList.add(value1);
        writeArrayList.add(value2);
       writeArrayList.add(1,value3);
        Integer element = writeArrayList.get(1);
        Assert.assertEquals(value3, element);*/

    }

    //как написать тест для метода add(int index, T value), если он ничего не возвращает
    @Test
    public void addTest2() {


    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndex() {
        writeArrayList.add(-5, value1);
    }

    //как написать тест, если не использовать метод add???
    @Test
    public void removeTest() {
        writeArrayList.add(value1);
        writeArrayList.add(value2);
        writeArrayList.add(1, value3);
        writeArrayList.remove(1);
        Integer element = writeArrayList.get(1);
        Assert.assertEquals(value2, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWrongIndex() {
        writeArrayList.add(value1);
        writeArrayList.remove(-5);
    }

    @Test
    public void containsTest() {
        writeArrayList.add(value1);
        writeArrayList.add(value2);
        Assert.assertTrue(writeArrayList.contains(value2));
    }

    @Test
    public void setTest() {
        writeArrayList.add(value1);
        writeArrayList.add(value2);
        Integer element = writeArrayList.set(0, value3);
        Assert.assertEquals(value3, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWrongIndex() {
        final int unexpectedIndex = -3;
        writeArrayList.set(unexpectedIndex, value3);
    }

    @Test
    public void sizeTest() {
        final int expectedSize = 5;
        for (int i = 0; i < expectedSize; i++) {
            writeArrayList.add(value2);
        }
        final int actualSize = writeArrayList.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void iteratorTest() {
        Assert.assertNotNull(writeArrayList.iterator());
    }

    @Test
    public void hasNextTest() {
        writeArrayList.add(value1);
        Assert.assertTrue(writeArrayList.iterator().hasNext());
    }

    @Test
    public void nextTest() {
        writeArrayList.add(value1);
        Assert.assertNotNull(writeArrayList.iterator().next());
        Integer element = writeArrayList.iterator().next();
        Assert.assertEquals(value1, element);
    }
}