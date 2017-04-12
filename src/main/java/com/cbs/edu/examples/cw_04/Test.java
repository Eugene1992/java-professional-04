package com.cbs.edu.examples.cw_04;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        SortedMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");

        System.out.println(treeMap.get(1));

        Map<Integer, String> hashMap = new HashMap<>();

        Comparator<? super Integer> comparator = treeMap.comparator();

        NavigableMap<Integer, String> newTreeMap = new TreeMap<>(comparator);
        newTreeMap.putAll(hashMap);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }
}
