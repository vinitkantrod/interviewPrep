package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfWordsYouCanType1935 {

    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) brokenSet.add(c);
        int count = 0;
        for (String s : arr) {
            Boolean canTypeWord = true;
            for (char c : s.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canTypeWord = false;
                    break;
                }
            }
            if (canTypeWord) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String t = "Hello World I am here";
        String b = "ad";
        System.out.println(canBeTypedWords(t, b));
    }
}
