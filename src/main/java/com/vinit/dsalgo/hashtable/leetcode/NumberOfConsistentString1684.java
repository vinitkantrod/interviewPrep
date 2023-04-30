package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConsistentString1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) set.add(allowed.charAt(i));
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            Boolean shouldAddWord = false;
            for (int j = 0; j < w.length(); j++) {
                if (!set.contains(w.charAt(j))) break;
                if (j == w.length() - 1 && set.contains(w.charAt(j))) shouldAddWord = true;
            }
            if (shouldAddWord) count++;
        }
        return count;
    }
}
