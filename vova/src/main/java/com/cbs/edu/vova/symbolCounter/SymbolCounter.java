package com.cbs.edu.vova.symbolCounter;

import java.util.*;

/**
 * Program count number of each letter o symbol in the string.
 */
public class SymbolCounter {
    /**
     * Program count number of each letter o symbol in the string.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string pls");
        String str = scan.next();
        int value = 1;
        str.toLowerCase();
        char[] arr = str.toCharArray();
        Map<String, Integer> hashMap = new HashMap();
        Iterator<Map.Entry<String, Integer>>
                itr = hashMap.entrySet().iterator();
        hashMap.put(String.valueOf(arr[0]), value);
        for (int i = 0; i < str.length(); i++) {
            while (itr.hasNext()) {
                if (itr.next().getKey().equals(String.valueOf(arr[i]))) {
                    value = itr.next().getValue() + 1;
                    hashMap.put(itr.next().getKey(), value);
                } else {
                    hashMap.put(String.valueOf(arr[i]), 1);
                }
            }
        }
        System.out.println(hashMap.keySet());
        while (itr.hasNext()) {
            System.out.println(itr.next().getKey());
        }
    }
}
