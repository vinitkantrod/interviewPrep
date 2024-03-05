package com.vinit.dsalgo.algoexpert.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacters {

    public static int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (!charMap.containsKey(string.charAt(i))) charMap.put(string.charAt(i), i);
            else charMap.put(string.charAt(i), -1);
        }
        for (Map.Entry m : charMap.entrySet()) {
            if ((int)m.getValue() >= 0) {
                return (int)m.getValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("abcxyzabc"));
    }
}
