package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length();i++) {
            int j = i;
            Set<Character> set = new HashSet<>();
            while (j < s.length()) {
                char c = s.charAt(j);
                if (set.contains(c)) break;
                else set.add(c);
                j++;
            }
            System.out.println(i + "-" + j + " : " + set);
            if (set.size() > max) max = set.size();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
