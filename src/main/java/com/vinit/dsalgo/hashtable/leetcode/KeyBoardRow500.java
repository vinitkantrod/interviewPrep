package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class KeyBoardRow500 {

    public static String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        Set<Character> set1 = new HashSet<>();
        String s1 = "qwertyuiopQWERTYUIOP";
        for (char c : s1.toCharArray()) set1.add(c);
        Set<Character> set2 = new HashSet<>();
        String s2 = "asdfghjklASDFGHJKL";
        for (char c : s2.toCharArray()) set2.add(c);
        Set<Character> set3 = new HashSet<>();
        String s3 = "zxcvbnmZXCVBNM";
        for (char c : s3.toCharArray()) set3.add(c);
        for (int i = 0; i < words.length; i++) {
            if (validWord(words[i],set1,set2,set3)) res.add(words[i]);
        }
        String[] r = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    public static Boolean validWord(String s, Set<Character> s1, Set<Character> s2, Set<Character> s3) {
        int checkSet = -1;
        if (s1.contains(s.charAt(0))) checkSet = 1;
        if (s2.contains(s.charAt(0))) checkSet = 2;
        if (s3.contains(s.charAt(0))) checkSet = 3;
        for (int i = 1; i < s.length(); i++) {
            if (checkSet == 1 && !s1.contains(s.charAt(i))) return false;
            if (checkSet == 2 && !s2.contains(s.charAt(i))) return false;
            if (checkSet == 3 && !s3.contains(s.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.asList(findWords(words)));
    }
}
