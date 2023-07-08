package com.vinit.dsalgo.slidingwindow.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ManimumNumberOfVowelInSubString1456 {
    public static int maxVowels(String s, int k) {
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowelSet.contains(s.charAt(i)) ? 1 : 0;
        }
        int ans = count;
        for (int i = k; i < s.length(); i++) {
            count += vowelSet.contains(s.charAt(i)) ? 1 : 0;
            count -= vowelSet.contains(s.charAt(i - k)) ? 1 : 0;
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
