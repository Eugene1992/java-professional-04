package com.cbs.edu.examples.io.patterns.decorator;

public class Test {
    public static void main(String[] args) {
        String data = "Хello world! \n Hello again!";

        StringReader stringReader = new StringReader(data);
        System.out.println(stringReader.read());

        BufferedReader bufferedReader = new BufferedReader(new StringReader(data));

        System.out.println(bufferedReader.readLine());


    }
}
