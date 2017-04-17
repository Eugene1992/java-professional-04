package com.cbs.edu.vladimir.hw_03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by Vladimir on 17.04.2017.
 */
public class MyLinkedListTest {
    private MyLinkedList<String> myLinkedList;
    private String TestValue;
    private int testIndex;

    @Before
    public void setUp() throws Exception {
        myLinkedList = new MyLinkedList(6);
        TestValue = "California";
        testIndex = 3;
    }

    @Test
    public void add() throws Exception {
        int getIndex = 0;
        myLinkedList.add(TestValue);
        Assert.assertEquals(myLinkedList.get(getIndex), TestValue);
    }

    @Test
    public void addIndex() throws Exception {
        myLinkedList.addIndex(testIndex, TestValue);
        Assert.assertEquals(TestValue, myLinkedList.get(testIndex));
    }

    @Test
    public void get() throws Exception {
        myLinkedList.addIndex(testIndex, TestValue);
        Assert.assertEquals(TestValue, myLinkedList.get(testIndex));
    }

    @Test
    public void set() throws Exception {
        myLinkedList.set(testIndex, TestValue);
        Assert.assertEquals(TestValue, myLinkedList.get(testIndex));
    }

    @Test
    public void contains() throws Exception {
        myLinkedList.add(TestValue);
        myLinkedList.contains(TestValue);
    }

    @Test
    public void remove() throws Exception {
        myLinkedList.addIndex(testIndex, TestValue);
        myLinkedList.remove(testIndex);
        Assert.assertEquals(null, myLinkedList.get(testIndex));
    }

}