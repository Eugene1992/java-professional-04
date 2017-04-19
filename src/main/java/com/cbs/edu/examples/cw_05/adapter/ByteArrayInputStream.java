package com.cbs.edu.examples.cw_05.adapter;

public class ByteArrayInputStream extends InputStream {

    private byte[] bytes;
    private int position = 0;

    public ByteArrayInputStream(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    int read() {
        return bytes[position++];
    }

    @Override
    int avaliable() {
        return bytes.length - position;
    }
}
