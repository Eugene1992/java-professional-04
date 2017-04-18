package com.cbs.edu.examples.cw_05.decorator;

public class WritableImpl implements Writable {

    @Override
    public void write(String str) {
        System.out.println(str);
    }
}
