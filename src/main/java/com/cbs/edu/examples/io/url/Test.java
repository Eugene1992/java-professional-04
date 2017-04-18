package com.cbs.edu.examples.io.url;

import java.io.*;
import java.net.URL;

/**
 * Created by evgeniy on 15/09/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://shop.oreilly.com/product/9780596007126.do");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("C:\\Users\\Evgeniy\\Desktop\\java-professional-04\\src\\main\\java\\com\\cbs\\edu\\examples\\io\\url\\index.html")
                )
        );
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            out.write(inputLine);
        }
        out.close();
        in.close();
    }
}
