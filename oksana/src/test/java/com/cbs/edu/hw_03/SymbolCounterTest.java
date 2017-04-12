package com.cbs.edu.hw_03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SymbolCounterTest {
    private Map<Character, Integer> expectedMap;
    private SymbolCounter counter;
    private String str;

    @Before
    public void setUp() {
        this.counter = new SymbolCounter();
        this.str = "Apple";
        expectedMap = new HashMap<>();
        expectedMap.put('A', 1);
        expectedMap.put('p', 2);
        expectedMap.put('l', 1);
        expectedMap.put('e', 1);
    }

    @Test
    public void counterTest() {
        Map<Character, Integer> rezultMap = counter.counter(str);
        Assert.assertEquals(expectedMap, rezultMap);
    }
}
