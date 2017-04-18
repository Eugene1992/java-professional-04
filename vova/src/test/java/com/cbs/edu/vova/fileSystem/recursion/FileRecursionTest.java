package com.cbs.edu.vova.fileSystem.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for file system recursion.
 */
public class FileRecursionTest {
    private FileRecursion file;

    @Before
    public void setUp() throws Exception {
        file = new FileRecursion("D:\\java-professional-04", "txt");
    }

    @Test
    public void find() throws Exception {
        file.find();
    }

}