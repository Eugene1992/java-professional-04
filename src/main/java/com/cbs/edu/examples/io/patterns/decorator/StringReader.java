package com.cbs.edu.examples.io.patterns.decorator;

public class StringReader extends Reader {

    private String data;
    private int cur;

    public StringReader(String data) {
        this.data = data;
    }

    @Override
    int read() {
        return data.getBytes()[cur++];
    }
}
