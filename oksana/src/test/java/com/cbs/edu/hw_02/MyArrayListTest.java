package com.cbs.edu.hw_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;
    private Integer value1;
    private Integer value2;
    private Integer value3;


    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
        value1 = 45;
        value2 = 50;
        value3 = 3;
    }

    @Test
    public void addTest1PlusGetTest() {

        Assert.assertTrue(myArrayList.add(value2));
        /*myArrayList.add(value1);
        myArrayList.add(value2);
       myArrayList.add(1,value3);
        Integer element = myArrayList.get(1);
        Assert.assertEquals(value3, element);*/

    }

    //как написать тест для метода add(int index, T value), если он ничего не возвращает
    @Test
    public void addTest2() {


    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndex() {
        myArrayList.add(-5, value1);
    }

    //как написать тест, если не использовать метод add???
    @Test
    public void removeTest() {
        myArrayList.add(value1);
        myArrayList.add(value2);
        myArrayList.add(1, value3);
        myArrayList.remove(1);
        Integer element = myArrayList.get(1);
        Assert.assertEquals(value2, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWrongIndex() {
        myArrayList.add(value1);
        myArrayList.remove(-5);
    }

    @Test
    public void containsTest() {
        myArrayList.add(value1);
        myArrayList.add(value2);
        Assert.assertTrue(myArrayList.contains(value2));
    }

    @Test
    public void setTest() {
        myArrayList.add(value1);
        myArrayList.add(value2);
        Integer element = myArrayList.set(0, value3);
        Assert.assertEquals(value3, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWrongIndex() {
        final int unexpectedIndex = -3;
        myArrayList.set(unexpectedIndex, value3);
    }

    @Test
    public void sizeTest() {
        final int expectedSize = 5;
        for (int i = 0; i < expectedSize; i++) {
            myArrayList.add(value2);
        }
        final int actualSize = myArrayList.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void iteratorTest() {
        Assert.assertNotNull(myArrayList.iterator());
    }

    @Test
    public void hasNextTest() {
        myArrayList.add(value1);
        Assert.assertTrue(myArrayList.iterator().hasNext());
    }

    @Test
    public void nextTest() {
        myArrayList.add(value1);
        Assert.assertNotNull(myArrayList.iterator().next());
        Integer element = myArrayList.iterator().next();
        Assert.assertEquals(value1, element);
    }

    @Test
    public void countSymbolTest() {
        Integer count = 11;
        Assert.assertNotNull(myArrayList.countSymbol());
        Assert.assertEquals(count, myArrayList.countSymbol().get("Hello, Java"));
    }
}
