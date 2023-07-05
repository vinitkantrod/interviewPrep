package com.vinit.dsalgo.strings.leetcode;

public class MergeStringAlternatively1768 {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        Boolean mergeSecond = false;
        while (i < word1.length() && j < word2.length()) {
            if (!mergeSecond) {
                sb.append(word1.charAt(i++));
                mergeSecond = true;
            } else {
                sb.append(word2.charAt(j++));
                mergeSecond = false;
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcdef", "pqr"));
    }
}
