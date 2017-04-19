package com.cbs.edu.examples.io.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Test {
    public static void main(String[] args) throws IOException {
        String data = "Hello world!";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(data));

        System.out.println(bufferedReader.readLine());
    }
}
