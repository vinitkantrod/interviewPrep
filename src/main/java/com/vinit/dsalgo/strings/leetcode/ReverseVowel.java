package com.vinit.dsalgo.strings.leetcode;


import java.util.HashMap;
import java.util.Map;

public class ReverseVowel {

    public static String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer(s);
        int leftPtr = 0;
        int rightPtr = s.length() - 1;
        Map<Character, Boolean> vowelsMap = new HashMap<>();
        vowelsMap.put('a', true);
        vowelsMap.put('e', true);
        vowelsMap.put('i', true);
        vowelsMap.put('o', true);
        vowelsMap.put('u', true);
        vowelsMap.put('A', true);
        vowelsMap.put('E', true);
        vowelsMap.put('I', true);
        vowelsMap.put('O', true);
        vowelsMap.put('U', true);
        while (leftPtr < rightPtr) {
            char ch1 = s.charAt(leftPtr);
            char ch2 = s.charAt(rightPtr);
            if (vowelsMap.containsKey(ch1) && vowelsMap.containsKey(ch2)) {
                sb.setCharAt(leftPtr, ch2);
                sb.setCharAt(rightPtr, ch1);
                leftPtr++;
                rightPtr--;
            } else if (vowelsMap.containsKey(ch1) && !vowelsMap.containsKey(ch2)){
                rightPtr--;
            } else if (!vowelsMap.containsKey(ch1) && vowelsMap.containsKey(ch2)) {
                leftPtr++;
            } else {
                leftPtr++;
                rightPtr--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "yo! Bottoms Up, u.S. Motto, boy!";
        System.out.println(reverseVowels(s));
    }
}
