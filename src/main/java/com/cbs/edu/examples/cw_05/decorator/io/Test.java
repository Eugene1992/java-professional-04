package com.cbs.edu.examples.cw_05.decorator.io;

public class Test {
    public static void main(String[] args) {
        String str = "Hello world! \n Hello Earth!";

        Reader reader = new StringReader(str);

        while (reader.ready()) {
            System.out.println((char)reader.read());
        }

        BufferedReader br = new BufferedReader(reader);

        System.out.println(br.readLine());
    }
}
