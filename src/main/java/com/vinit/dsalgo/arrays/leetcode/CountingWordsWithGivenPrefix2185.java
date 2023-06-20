package com.vinit.dsalgo.arrays.leetcode;

public class CountingWordsWithGivenPrefix2185 {

    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String s : words) {
            if (s.length() < pref.length()) continue;
            if (s.substring(0, pref.length()).equals(pref)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String[] s = {"pay","attention","practice","attend"};
        System.out.println(prefixCount(s, "at"));
    }
}
