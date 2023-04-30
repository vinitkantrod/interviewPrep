package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard1165 {

    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            alphabetMap.put(keyboard.charAt(i), i);
        }
//        System.out.println(alphabetMap);
        int steps = 0;
        int oldIdx = 0;
        for (char c: word.toCharArray()) {
            int newIdx = alphabetMap.get(c);
            steps += Math.abs(newIdx - oldIdx);
            oldIdx = newIdx;
        }
        return steps;
    }
    public static void main(String[] args) {
//        String keyboard = "abcdefghijklmnopqrstuvwxyz";
//        String word = "cba";
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "leetcode";
        System.out.println(calculateTime(keyboard, word));
    }
}
