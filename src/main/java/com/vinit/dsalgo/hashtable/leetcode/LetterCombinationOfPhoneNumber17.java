package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class LetterCombinationOfPhoneNumber17 {

    public static List<String> letterCombinations(String digits) {
        List<String> lst = new ArrayList<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, new ArrayList<>(Arrays.asList('a','b','c')));
        map.put(3, new ArrayList<>(Arrays.asList('d','e','f')));
        map.put(4, new ArrayList<>(Arrays.asList('g','h','i')));
        map.put(5, new ArrayList<>(Arrays.asList('j','k','l')));
        map.put(6, new ArrayList<>(Arrays.asList('m','n','o')));
        map.put(7, new ArrayList<>(Arrays.asList('p','q','r','s')));
        map.put(8, new ArrayList<>(Arrays.asList('t','u','v')));
        map.put(9, new ArrayList<>(Arrays.asList('w','x','y','z')));
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
//            String s = getChar(c, map, "");
            lst.add("");
        }
        return lst;
    }

    public static void getChar(char s, Map<Integer, List<Character>> map, String res) {

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
