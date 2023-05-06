package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SubStringOfSizeThreeWithDistinctChar1876 {

    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (
                    s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i) != s.charAt(i + 2) &&
                    s.charAt(i + 1) != s.charAt(i + 2)
            ) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
