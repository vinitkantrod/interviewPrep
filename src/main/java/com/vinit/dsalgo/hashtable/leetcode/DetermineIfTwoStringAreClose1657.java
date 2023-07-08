package com.vinit.dsalgo.hashtable.leetcode;

import java.util.Arrays;

public class DetermineIfTwoStringAreClose1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word2.length() != word1.length()) return false;
        int[] word1Map = new int[26];
        int[] word2Map = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (word1Map[i] == 0 && word2Map[i] > 0 ||
            word2Map[i] == 0 && word1Map[i] > 0) return false;
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        return Arrays.equals(word1Map, word2Map);
    }
}
