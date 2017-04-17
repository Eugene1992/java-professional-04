package com.cbs.edu.vladimir.hw_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vladimir on 15.04.2017.
 */
public class MyListTest {

    private MyList<String> myList;
    private String TestValue;
    private int testIndex;

    @Before
    public void setUp() throws Exception {
        myList = new MyList(6);
        TestValue = "California";
        testIndex = 3;
    }

    @Test
    public void add() throws Exception {
        int getIndex = 0;
        myList.add(TestValue);
        Assert.assertEquals(myList.get(getIndex), TestValue);


    }

    @Test
    public void addIndex() throws Exception {
        myList.addIndex(testIndex, TestValue);
        Assert.assertEquals(TestValue, myList.get(testIndex));
    }

    @Test
    public void get() throws Exception {
        myList.addIndex(testIndex, TestValue);
        Assert.assertEquals(TestValue, myList.get(testIndex));
    }

    @Test
    public void set() throws Exception {
        myList.set(testIndex, TestValue);
        Assert.assertEquals(TestValue, myList.get(testIndex));

    }

    @Test
    public void contains() throws Exception {
        myList.add(TestValue);
        myList.contains(TestValue);
    }

    @Test
    public void remove() throws Exception {
        myList.addIndex(testIndex, TestValue);
        myList.remove(testIndex);
        Assert.assertEquals(null, myList.get(testIndex));
    }


}