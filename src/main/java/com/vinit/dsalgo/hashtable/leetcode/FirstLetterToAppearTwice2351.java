package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstLetterToAppearTwice2351 {

    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Character ch = Character.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                ch = c;
                break;
            }
            map.put(c, 1);
        }
        return ch;
    }
}
