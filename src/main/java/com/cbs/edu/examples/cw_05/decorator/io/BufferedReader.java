package com.cbs.edu.examples.cw_05.decorator.io;

public class BufferedReader extends Reader {

    private Reader reader;

    public BufferedReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    int read() {
        return 0;
    }

    @Override
    boolean ready() {
        return false;
    }

    public String readLine() {
        String str = "";
        while (reader.ready()) {
            int aChar = reader.read();
            if (aChar != '\n') {
                str = str + aChar;
            } else {
                return str;
            }
        }
        return str;
    }
}
