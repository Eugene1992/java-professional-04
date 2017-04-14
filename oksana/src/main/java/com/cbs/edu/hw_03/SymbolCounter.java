package com.cbs.edu.hw_03;

import java.util.HashMap;
import java.util.Map;
/**
 * Implementation SymbolCounter, which counts number of symbols.
 *
 */
public class SymbolCounter {
    private int count;
    private Map<Character, Integer> map;

    public SymbolCounter() {
        map = new HashMap<>();
    }

    /** Fills the collection by the key character, the value is the number
     * of characters in the string.
     *
     * @param str specified object
     * @return created map
     */
    public Map<Character, Integer> counter(String str) {
        for (int i = 0; i < str.length(); i++) {
            count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    ++count;
                }
            }
            map.put(str.charAt(i), count);
        }
        return map;
    }
}
