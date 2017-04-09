package com.cbs.edu.leson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class MyStackTest {

    private MyStack<String> myStack;
    private String testValue;

    @Before
    public void setUp() {
        myStack = new MyStack<>();
        testValue = "Hello world!";
    }

    @Test
    public void pushTest() {
        myStack.push(testValue);
        String savedValue = myStack.pop();
        Assert.assertEquals(savedValue, testValue);
    }

    @Test(expected = EmptyStackException.class)
    public void popFromEmptyTest() {
        myStack.pop();
    }
}
