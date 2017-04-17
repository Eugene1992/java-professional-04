package com.cbs.edu.vladimir.hw_03_vladimir;


import java.util.HashMap;

/**
 * Created by Vladimir on 17.04.2017.
 */
public class MyMap {
    /**
     * Main method.
     */
    public static void main(String[] args) {
        String line = "Hellooo";
        int quantityRepeated = 0;

        HashMap<Integer, Character> hashMap = new HashMap<Integer, Character>();
        for (int i = 0; i < line.length(); ++i) {
            char charLine = line.charAt(i);

            if (hashMap.containsValue(charLine)) {
                System.out.println("повторяется " + charLine);
                quantityRepeated += 1;
            }

            hashMap.put(i, charLine);
//            System.out.println(hashMap);
        }
        System.out.println("Cумма повторений - " + quantityRepeated);
    }
}
