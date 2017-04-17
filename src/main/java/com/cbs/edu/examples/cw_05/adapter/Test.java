package com.cbs.edu.examples.cw_05.adapter;

public class Test {
    public static void main(String[] args) {
        byte[] bytes = {123, 43, 12, 55, 23};

        InputStream is = new ByteArrayInputStream(bytes);

        while (is.avaliable() > 0) {
            System.out.println(is.read());
        }
    }
}
