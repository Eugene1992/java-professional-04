package com.cbs.edu.vladimir.hw_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vladimir on 15.04.2017.
 */
public class MyListTest {

    private MyList<String> myList;
    private String testValue;
    private int testIndex;

    @Before
    public void setUp() throws Exception {
        myList = new MyList<>(6);
        testValue = "California";
        testIndex = 3;
    }

    @Test
    public void add() throws Exception {
        int getIndex = 0;
        myList.add(testValue);
        Assert.assertEquals(myList.get(getIndex), testValue);
    }

    @Test
    public void addIndex() throws Exception {
        myList.addIndex(testIndex, testValue);
        Assert.assertEquals(testValue, myList.get(testIndex));
    }

    @Test
    public void get() throws Exception {
        myList.addIndex(testIndex, testValue);
        Assert.assertEquals(testValue, myList.get(testIndex));
    }

    @Test
    public void set() throws Exception {
        myList.set(testIndex, testValue);
        String actual = myList.get(testIndex);
        Assert.assertEquals(testValue, actual);
    }

    @Test
    public void contains() throws Exception {
        myList.add(testValue);
        boolean result = myList.contains(testValue);
        Assert.assertTrue(result);
    }

    @Test
    public void remove() throws Exception {
        myList.addIndex(testIndex, testValue);
        myList.remove(testIndex);
        Assert.assertNull(myList.get(testIndex));
    }
}