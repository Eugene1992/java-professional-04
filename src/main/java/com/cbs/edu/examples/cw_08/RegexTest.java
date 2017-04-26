package com.cbs.edu.examples.cw_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String str = "deyneko55@gmail.com";
        Pattern p = Pattern.compile("[a-zA-Z]{4}"); // \\w == a-zA-Z0-9_
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
    }
}
