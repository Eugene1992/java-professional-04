package com.cbs.edu.examples.io.patterns.adapter;

public class Test {
    public static void main(String[] args) {
        byte[] data = new byte[]{12, 43, 23, 23};
        String stringData = "Hello world!";

        InputStream in = new ByteArrayInputStream(data);
        InputStream ins = new StringInputStream(stringData);

        printByte(in);
        printByte(ins);

    }

    static void printByte(InputStream in) {
        System.out.println(in.read());
    }
}
