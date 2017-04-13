package com.cbs.edu.leson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Волк
 * Date: 13.04.17
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class WriteLinkedListTest {
    private WriteLinkedList<String> linkedList;
    private String testValue;

    @Before
    public void setUp() {
        linkedList = new WriteLinkedList<>();
        testValue = "Hello world!";
    }

    @Test
    public void addTest() {
        linkedList.add(testValue);
        String savedValue = linkedList.get(1);
        Assert.assertEquals(savedValue, testValue);
    }

    /*@Test(expected = EmptyStackException.class)
    public void popFromEmptyTest() {
        linkedList.get(linkedList.size());
} */
}