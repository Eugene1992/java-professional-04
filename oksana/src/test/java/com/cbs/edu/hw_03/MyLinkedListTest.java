package com.cbs.edu.hw_03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
    private MyLinkedList<Integer> myLinkedList;
    private Integer valueFirst;
    private Integer valueSecond;
    private final int incorrectIndex = -3;

    @Before
    public void setUp() {
        myLinkedList = new MyLinkedList<>();
        valueFirst = 45;
        valueSecond = 50;
    }

    @Test
    public void addLastTest() {
        Assert.assertTrue(myLinkedList.addLast(valueFirst));
    }

    @Test
    public void addFirstTest() {
        myLinkedList.addLast(valueFirst);
        Assert.assertTrue(myLinkedList.addFirst(valueSecond));
    }

    @Test
    public void addByIndexTest() {
        final int index = 0;
        myLinkedList.addLast(valueFirst);
        myLinkedList.addByIndex(index, valueSecond);
        Integer element = myLinkedList.get(index);
        Assert.assertEquals(valueSecond, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndex() {
        myLinkedList.addByIndex(incorrectIndex, valueFirst);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWrongIndex() {
        myLinkedList.get(incorrectIndex);
    }

    @Test
    public void containsTest() {
        myLinkedList.addLast(valueFirst);
        Assert.assertTrue(myLinkedList.contains(valueFirst));
    }

    @Test
    public void removeTest() {
        final int index = 0;
        myLinkedList.addLast(valueFirst);
        myLinkedList.addLast(valueSecond);
        myLinkedList.remove(index);
        Integer element = myLinkedList.get(index);
        Assert.assertEquals(valueSecond, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWrongIndex() {
        myLinkedList.remove(incorrectIndex);
    }

    @Test
    public void setTest() {
        final int index = 0;
        myLinkedList.addLast(valueFirst);
        Integer element = myLinkedList.set(index, valueSecond);
        Assert.assertEquals(valueSecond, element);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWrongIndex() {
        myLinkedList.set(incorrectIndex, valueFirst);
    }

    @Test
    public void sizeTest() {
        final int expectedSize = 5;
        for (int i = 0; i < expectedSize; i++) {
            myLinkedList.addLast(valueFirst);
        }
        final int actualSize = myLinkedList.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void iteratorTest() {
        Assert.assertNotNull(myLinkedList.iterator());
    }

    @Test
    public void hasNextTest() {
        myLinkedList.addLast(valueFirst);
        Assert.assertTrue(myLinkedList.iterator().hasNext());
    }

    @Test
    public void nextTest() {
        myLinkedList.addLast(valueFirst);
        Assert.assertNotNull(myLinkedList.iterator().next());
        Integer element = myLinkedList.iterator().next();
        Assert.assertEquals(valueFirst, element);
    }
}
