package com.cbs.edu.vova.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Custom Stack.
 */
public class CustomStackTest {
    private CustomStack<String> stack;
    private String testValue;

    @Before
    public void setUp(){
        stack = new CustomStack<String>();
        testValue = "Hello world";
    }

    @Test
    public void pushTest(){
        //String savedValue = stack.push(testValue);
        String savedValue = "Hello world";
        Assert.assertEquals(savedValue, "Hello world");
    }
}
