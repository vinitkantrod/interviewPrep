package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoatLatin824 {

    public static String toGoatLatin(String sentence) {
        String[] stringArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for (int i = 0; i < stringArr.length; i++) {
            String charA = String.valueOf('a').repeat(i + 1);
            String s = stringArr[i];
            if (vowelSet.contains(s.charAt(0))) {
                sb.append(s + "ma" +charA);
            } else {
                char frontChar = s.charAt(0);
                String newString = s.substring(1);
                newString = newString + frontChar + "ma" + charA;
                sb.append(newString);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
