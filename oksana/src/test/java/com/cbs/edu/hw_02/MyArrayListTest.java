package com.cbs.edu.hw_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;
    private Integer valueFirst;
    private Integer valueSecond;
    private final int incorrectIndex = -3;

    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
        valueFirst = 45;
        valueSecond = 50;
    }

    @Test
    public void addTest1() {
        Assert.assertTrue(myArrayList.add(valueFirst));
    }

    @Test
    public void addTest2() {
        final int index = 0;
        myArrayList.add(valueFirst);
        myArrayList.add(index, valueSecond);
        Integer element = myArrayList.get(index);
        Assert.assertEquals(valueSecond, element);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndex() {
        myArrayList.add(incorrectIndex, valueFirst);
    }

    @Test
    public void removeTest() {
        final int index = 0;
        myArrayList.add(valueFirst);
        myArrayList.add(valueSecond);
        myArrayList.remove(index);
        Integer element = myArrayList.get(index);
        Assert.assertEquals(valueSecond, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWrongIndex() {
        myArrayList.remove(incorrectIndex);
    }

    @Test
    public void containsTest() {
        myArrayList.add(valueFirst);
        Assert.assertTrue(myArrayList.contains(valueFirst));
    }

    @Test
    public void setTest() {
        final int index = 0;
        myArrayList.add(valueFirst);
        Integer element = myArrayList.set(index, valueSecond);
        Assert.assertEquals(valueSecond, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWrongIndex() {
        myArrayList.set(incorrectIndex, valueFirst);
    }

    @Test
    public void sizeTest() {
        final int expectedSize = 5;
        for (int i = 0; i < expectedSize; i++) {
            myArrayList.add(valueFirst);
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
        myArrayList.add(valueFirst);
        Assert.assertTrue(myArrayList.iterator().hasNext());
    }

    @Test
    public void nextTest() {
        myArrayList.add(valueFirst);
        Assert.assertNotNull(myArrayList.iterator().next());
        Integer element = myArrayList.iterator().next();
        Assert.assertEquals(valueFirst, element);
    }
}
