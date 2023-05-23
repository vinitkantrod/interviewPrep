package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueThreePalindrome1930 {

    public int countPalindromicSubsequence(String s) {
        // Find first and last occurance of each charaters.
        // and find no of unique char in between them and add it to result.
        int first[] = new int[26], last[] = new int[26], res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (first[i] < last[i])
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
        return res;
    }
}
