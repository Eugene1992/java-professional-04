package com.cbs.edu.examples.io.patterns.decorator;

public class BufferedReader extends Reader {

    private Reader reader;

    public BufferedReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    int read() {
        return reader.read();
    }

    public String readLine() {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            char curByte = (char)read();
            if (curByte == '\n') break;
            stringBuilder.append(curByte);
        }
        return stringBuilder.toString();
    }
}
