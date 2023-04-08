package com.vinit.dsalgo.strings.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveVowelsFromString {

    public static String removeVowels(String s) {
        Map<Character, Boolean> vowelsMap = new HashMap<>();
        vowelsMap.put('a', true);
        vowelsMap.put('e', true);
        vowelsMap.put('i', true);
        vowelsMap.put('o', true);
        vowelsMap.put('u', true);
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!vowelsMap.containsKey(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(removeVowels(s));
    }
}
