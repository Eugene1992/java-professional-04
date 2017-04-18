package com.cbs.edu.vladimir.hw_01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vladimir on 10.04.2017.
 */
public class BestStackTest {


    private BestStack<String> bestStack;
    String value = "stack";
    @Before
    public void setUp() throws Exception {
        bestStack = new BestStack<>();
        String value = "stack";
    }

    @Test
    public void push() throws Exception {
        String savedValue = bestStack.push(value);
        Assert.assertEquals(savedValue,bestStack.pop());

    }
    @Test
    public void pop() throws Exception {

    }

}