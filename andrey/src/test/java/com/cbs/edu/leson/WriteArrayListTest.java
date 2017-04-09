package com.cbs.edu.leson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

/**
 • add(T value)
 • add(int index, T value)
 • get(int index)
 • set(int index, T value)
 • contains(T value)
 • remove(int index)
 • iterator()
 • size()
 */
public class WriteArrayListTest {
    private WriteArrayList<String> arrList;
    private String testValue;

    @Before
    public void setUp() {
        arrList = new WriteArrayList<>();
        testValue = "Hello world!";
    }

    @Test
    public void addTest() {
        arrList.add(testValue);
        String savedValue = arrList.get(arrList.size());
        Assert.assertEquals(savedValue, testValue);
    }

    @Test(expected = EmptyStackException.class)
    public void popFromEmptyTest() {
        arrList.get(arrList.size());
    }
}
