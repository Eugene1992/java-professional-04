package com.cbs.edu.examples.cw_05.decorator;

public class Test {
    public static void main(String[] args) {
        Writable writable = new WritableImpl();

        writable.write("Hello world!");

        BracketDecorator bracketDecorator = new BracketDecorator(writable);

        bracketDecorator.write("Hello world!");
    }
}
