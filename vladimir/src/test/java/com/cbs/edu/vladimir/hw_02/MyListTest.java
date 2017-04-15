package com.cbs.edu.vladimir.hw_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vladimir on 15.04.2017.
 */
public class MyListTest {

    private MyList<String> myList;
    private String firstTestValue;
    private String secondTestValue;
    private String thirdTestValue;
    private int testIndex;

    @Before
    public void setUp() throws Exception {
        myList = new MyList(6);
        firstTestValue = "California";
        secondTestValue = "Philadelphia";
        thirdTestValue = "New York";
        testIndex = 3;
    }

    @Test
    public void add() throws Exception {
        int getIndex = 0;
        myList.add(firstTestValue);
        Assert.assertEquals(myList.get(getIndex), firstTestValue);


    }

    @Test
    public void addIndex() throws Exception {
        myList.addIndex(testIndex, firstTestValue);
        Assert.assertEquals(firstTestValue, myList.get(testIndex));
    }

    @Test
    public void get() throws Exception {
        myList.addIndex(testIndex, firstTestValue);
        Assert.assertEquals(firstTestValue, myList.get(testIndex));
    }

    @Test
    public void set() throws Exception {
        myList.set(testIndex, firstTestValue);
        Assert.assertEquals(firstTestValue, myList.get(testIndex));

    }

    @Test
    public void contains() throws Exception {
        myList.add(firstTestValue);
        myList.contains(firstTestValue);
    }

    @Test
    public void remove() throws Exception {
        myList.addIndex(testIndex, firstTestValue);
        myList.remove(testIndex);
        Assert.assertEquals(null, myList.get(testIndex));
    }


}