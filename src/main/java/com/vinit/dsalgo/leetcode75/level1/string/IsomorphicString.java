package com.vinit.dsalgo.leetcode75.level1.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> isomorphicMap = new HashMap<>();
        Set<Character> mapSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (isomorphicMap.containsKey(ch1)) {
                if (isomorphicMap.get(ch1) != ch2) return false;
            } else {
                System.out.println(mapSet);
                if (mapSet.contains(ch2)) return false;
                isomorphicMap.put(ch1, ch2);
                mapSet.add(ch2);
            }
        }
        System.out.println(isomorphicMap);
        return true;
    }
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }
}
