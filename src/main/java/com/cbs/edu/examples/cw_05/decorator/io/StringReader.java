package com.cbs.edu.examples.cw_05.decorator.io;

public class StringReader extends Reader {

    private char[] chars;
    private int position = 0;

    public StringReader(String string) {
        this.chars = string.toCharArray();
    }

    @Override
    int read() {
        return chars[position++];
    }

    @Override
    boolean ready() {
        return chars.length - position > 0;
    }
}
