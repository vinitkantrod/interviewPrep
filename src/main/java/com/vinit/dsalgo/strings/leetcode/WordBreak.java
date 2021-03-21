package com.vinit.dsalgo.strings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        return topDown(s, new HashSet<>(wordDict), 0, new Boolean[s.length() + 1]);
    }

    public static Boolean topDown(String s, HashSet<String> wordDict, int startIdx, Boolean[] cache) {
        if (startIdx == s.length()) return true;
        if (cache[startIdx] != null) return cache[startIdx];
        for (int endIdx = startIdx + 1; endIdx <= s.length(); endIdx++) {
            if (wordDict.contains(s.substring(startIdx, endIdx)) && topDown(s, wordDict, endIdx, cache)) {
                cache[startIdx] = true;
                return true;
            }
        }
        cache[startIdx] = false;
        return false;
    }

    public static void main(String args[]) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "and", "dog"))));
    }
}
