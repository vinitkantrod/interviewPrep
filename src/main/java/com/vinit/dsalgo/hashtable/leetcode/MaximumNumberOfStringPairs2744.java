package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfStringPairs2744 {

    public static int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> stringMap = new HashMap<>();
        int count = 0;
        for (String s : words) {
            String reverseWord = reverseWord(s);
            if (stringMap.containsKey(reverseWord) && stringMap.get(reverseWord) > 0) {
                stringMap.put(reverseWord, stringMap.get(reverseWord) - 1);
                count++;
            } else {
                stringMap.put(s, stringMap.getOrDefault(s, 0) + 1);
            }
        }
        return count;
    }

    public static String reverseWord(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = {"ab","cd", "cd","ac","dc","ca","zz"};
        System.out.println(maximumNumberOfStringPairs(s));
    }
}
