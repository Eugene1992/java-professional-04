package com.cbs.edu.vova.arrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by DarKnight on 010 10.04.17.
 */
public class MyArrayListTest {
    private MyArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new MyArrayList<Integer>(10);
        for (int i = 0; i < 15; i++) {
            list.addValue(i * 10);
        }
    }

    @Test
    public void addValueTest() {
        int ACTUAL = list.get(3);
        int EXPECTED = 30;
        Assert.assertEquals(EXPECTED, ACTUAL);
        ACTUAL = list.get(10);
        EXPECTED = 100;
        Assert.assertEquals(EXPECTED, ACTUAL);
        ACTUAL = list.get(14);
        EXPECTED = 140;
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    /*
    @Test
    public void addValueIndexTest(){
        list.addValue(11,200);
        int ACTUAL = list.get(11);
        int EXPECTED = 200;
        Assert.assertEquals(EXPECTED,ACTUAL);
    }
    */

    @Test
    public void setValueTest() {
        list.setValue(11, 200);
        int ACTUAL = list.get(11);
        int EXPECTED = 200;
        Assert.assertEquals(EXPECTED, ACTUAL);
        list.setValue(9, 900);
        ACTUAL = list.get(9);
        EXPECTED = 900;
        Assert.assertEquals(EXPECTED, ACTUAL);
        list.setValue(5, 55);
        ACTUAL = list.get(5);
        EXPECTED = 55;
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

/*
    @Test
    public void setValueExceptionTest(){
        list.setValue(20,200);
        String ACTUAL = "Index over array capacity";
        Assert.assertEquals(IndexOutOfBoundsException.class,ACTUAL);
    }
    */

    @Test
    public void containtsValueTest() {
        int ACTUAL = list.containsValue(120);
        int EXPECTED = 12;
        Assert.assertEquals(EXPECTED, ACTUAL);
        ACTUAL = list.containsValue(10);
        EXPECTED = 1;
        Assert.assertEquals(EXPECTED, ACTUAL);
        ACTUAL = list.containsValue(90);
        EXPECTED = 9;
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    /*
    @Test
    public void removeValueTest() {
        list.removeValue(12);
        int ACTUAL = list.get(12);
        int EXPECTED = 130;
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
    */
}
