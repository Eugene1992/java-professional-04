package com.cbs.edu.examples.io.patterns.adapter;

public class StringInputStream extends InputStream {

    private String data;
    private int cur;

    public StringInputStream(String data) {
        this.data = data;
    }

    @Override
    int read() {
        return data.getBytes()[cur++];
    }
}
