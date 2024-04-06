package com.vinit.dsalgo.slidingwindow.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubStringWithConcatenationOfAllWord30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        // Permetuation of all words
        Set<String> permutations = getPermutationsOfWords(words);
        List<Integer> result = new ArrayList<>();
        for (String perm : permutations) {
            int permLen = perm.length();
            for (int i = 0; i <= s.length() - permLen; i++) {
                if (s.substring(i, i + permLen).equals(perm)) result.add(i);
            }
        }
        return result;
    }

    private static Set<String> getPermutationsOfWords(String[] words) {
        Set<String> uniqueString = new HashSet<>();
        getPermutation(words, 0, uniqueString);
        return uniqueString;
    }

    private static void getPermutation(String[] words, int index, Set<String> result) {
        if (index == words.length - 1) {
            String newString = generateString(words);
            result.add(newString);
        }
        for (int i = index; i <= words.length - 1; i++) {
            swap(words, index, i);
            getPermutation(words, index + 1, result);
            swap(words, index, i);
        }
    }

    private static String generateString(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private static void swap(String[] words, int start, int end) {
        String tempStr = words[start];
        words[start] = words[end];
        words[end] = tempStr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(findSubstring("foobarfoobar", new String[] {"foo", "bar"})));
    }
}
