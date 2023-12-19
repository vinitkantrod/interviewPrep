package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> wordMap = new HashMap<>();
        Map<String, Character> charMap = new HashMap<>();
        String[] sArr = s.split(" ");
        char[] ch = pattern.toCharArray();
        if (ch.length != sArr.length) return false;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            String word = sArr[i];
            if (wordMap.containsKey(c) && !wordMap.get(c).equals(word)) return false;
            if (charMap.containsKey(word) && !charMap.get(word).equals(c)) return false;
            wordMap.put(c, word);
            charMap.put(word, c);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String word = "dog cat cat dog";
        System.out.println(wordPattern(pattern, word));
    }
}
