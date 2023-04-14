package com.vinit.dsalgo.leetcode75.level1.greedy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character key = magazine.charAt(i);
            if (characterIntegerMap.containsKey(key)) {
                characterIntegerMap.put(key, characterIntegerMap.get(key) + 1);
            } else {
                characterIntegerMap.put(key, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character key = ransomNote.charAt(i);
            if (characterIntegerMap.containsKey(key)) {
                if (characterIntegerMap.get(key) == 0) return false;
                else characterIntegerMap.put(key, characterIntegerMap.get(key) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abc", "abc"));
    }
}
