package com.vinit.dsalgo.leetcode75.level1.greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {

    public static int longestPalindrome(String s) {
//        Map<Character, Integer> characterIntegerMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character key = s.charAt(i);
//            characterIntegerMap.put(key,
//                    characterIntegerMap.containsKey(key) ?
//                            characterIntegerMap.get(key) + 1 : 1);
//        }
//        System.out.println(characterIntegerMap);
//        int palindromeLength = 0;
//        int maxOddLength = 0;
//        for (Map.Entry e : characterIntegerMap.entrySet()) {
//            if ((int) e.getValue() % 2 == 0)
//                palindromeLength += (int) e.getValue();
//            else {
//                if ( (int) e.getValue() > maxOddLength) maxOddLength = (int) e.getValue();
//            }
//        }
//        palindromeLength += maxOddLength;
//        return palindromeLength;

        int odd = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
        for(Object value : map.values()) if((int)value%2 != 0) odd++;

        return odd > 0? n - odd + 1: n;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbcccddddeeEEEffFFgFFFhhhhhh"));
    }
}
