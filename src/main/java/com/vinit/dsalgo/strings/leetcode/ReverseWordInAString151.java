package com.vinit.dsalgo.strings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordInAString151 {

    public static String reverseWords(String s) {
        List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(wordList);
        System.out.println(wordList);
        return String.join( " ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is    blue     "));
    }
}
