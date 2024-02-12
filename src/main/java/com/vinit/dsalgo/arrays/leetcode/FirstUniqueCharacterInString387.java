package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString387 {

    public static int firstUniqChar(String s) {
        // initialze hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aleetcodez"));
    }
}
