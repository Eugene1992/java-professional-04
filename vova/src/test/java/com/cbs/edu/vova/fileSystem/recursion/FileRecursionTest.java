package com.cbs.edu.vova.fileSystem.recursion;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for file system recursion.
 */
public class FileRecursionTest {
    private FileRecursion file;

    @Before
    public void setUp() throws Exception {
        file = new FileRecursion(System.getProperty("user.dir"), "txt");
    }

    @Test
    public void find() throws Exception {
        file.find();
    }

}