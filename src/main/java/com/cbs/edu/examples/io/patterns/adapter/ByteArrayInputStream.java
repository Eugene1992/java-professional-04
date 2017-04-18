package com.cbs.edu.examples.io.patterns.adapter;

public class ByteArrayInputStream extends InputStream {

    private byte[] data;
    private int curs = 0;

    public ByteArrayInputStream(byte[] data) {
        this.data = data;
    }

    @Override
    int read() {
        return data[curs++];
    }
}
