package com.cbs.edu.examples.cw_03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> objects = new HashMap<>();

        objects.put(1, "One");
        objects.put(2, "Two");
        objects.put(3, "Three");
        objects.put(1000, "Thousand");
        objects.put(100, "Hundred");

        Set<Map.Entry<Integer, String>> entries = objects.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {

        }

        Set<Integer> integers = objects.keySet();
        Collection<String> values = objects.values();

        System.out.println(objects);
    }
}
