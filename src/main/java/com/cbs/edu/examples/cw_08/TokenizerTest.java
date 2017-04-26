package com.cbs.edu.examples.cw_08;

import java.util.StringTokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("Hello my dear world!", " ", true);

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            System.out.println(token);
        }
    }
}
