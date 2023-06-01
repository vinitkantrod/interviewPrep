package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class LetterCombinationOfLeetCode17 {

    public static Map<Character, List<Character>> phoneMap;
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        phoneMap = new HashMap<>();
        List<String> output = new ArrayList<>();
        generatePhoneMap();
        for (int i = 0; i < phoneMap.get(digits.charAt(0)).size(); i++) {
            combination(1, digits, "" + phoneMap.get(digits.charAt(0)).get(i), output);
        }
        return output;
    }

    public static void combination(int index, String digit, String s, List<String> output) {
        if (s.length() == digit.length()) {
            output.add(s);
            return;
        }
        for (int j = 0; j < phoneMap.get(digit.charAt(index)).size(); j++) {
            s += phoneMap.get(digit.charAt(index)).get(j);
            combination(index + 1, digit, s, output);
            s = s.substring(0, s.length() - 1);
        }
    }
    public static void generatePhoneMap() {
        phoneMap.put('2', new ArrayList<>(Arrays.asList('a','b','c')));
        phoneMap.put('3', new ArrayList<>(Arrays.asList('d','e','f')));
        phoneMap.put('4', new ArrayList<>(Arrays.asList('g','h','i')));
        phoneMap.put('5', new ArrayList<>(Arrays.asList('j','k','l')));
        phoneMap.put('6', new ArrayList<>(Arrays.asList('m','n','o')));
        phoneMap.put('7', new ArrayList<>(Arrays.asList('p','q','r','s')));
        phoneMap.put('8', new ArrayList<>(Arrays.asList('t','u','v')));
        phoneMap.put('9', new ArrayList<>(Arrays.asList('w','x','y','z')));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(letterCombinations("23")));
    }
}
