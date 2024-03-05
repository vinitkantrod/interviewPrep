package com.vinit.dsalgo.algoexpert.strings;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        if (characters.length() != document.length()) return false;
        Map<Integer, Integer> asciiMap = new HashMap<>();
        for (char c : characters.toCharArray()) {
            int ascii = (int) c;
            asciiMap.put(ascii, asciiMap.getOrDefault(ascii, 0) + 1);
        }
        for (char c : document.toCharArray()) {
            int ascii = (int) c;
            asciiMap.put(ascii, asciiMap.getOrDefault(ascii, 0) - 1);
            if (asciiMap.get(ascii) < 0) return false;
        }
        return true;
    }
}
