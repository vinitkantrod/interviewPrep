package com.vinit.dsalgo.arrays.leetcode;

public class TwoStringArrayEquivalent {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (String s: word1) {
            stringBuilder1.append(s);
        }
        for (String s: word2) {
            stringBuilder2.append(s);
        }
        if (stringBuilder1.toString().equals(stringBuilder2.toString())) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "cb"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
