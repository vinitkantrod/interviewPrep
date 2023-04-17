package com.vinit.dsalgo.strings.algoexpert;

import java.util.*;

public class MinimumCharactersForWords {

    public static char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i< words.length; i++) {
            Map<Character, Integer> wordsMap = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                wordsMap.put(c, wordsMap.containsKey(c) ? wordsMap.get(c) + 1 : 1);
            }
            for (Map.Entry m : wordsMap.entrySet()) {
                if (characterMap.containsKey(m.getKey())) {
                    if ((int) m.getValue() > characterMap.get(m.getKey()))
                        characterMap.put((char) m.getKey(), (int) m.getValue());
                } else {
                    characterMap.put((char) m.getKey(), (int) m.getValue());
                }
            }
            System.out.println(wordsMap);
        }
        System.out.println(characterMap);


        List<Character> ch = new ArrayList<>();
        int i = 0;
        for (Map.Entry c : characterMap.entrySet()) {
            int count = (int) c.getValue();
            System.out.println(c + " - " + count);
            while (count > 0) {
                ch.add((char) c.getKey());
                count--;
            }
        }

        char[] res = new char[ch.size()];
        for (char c : ch) {
            res[i] = c;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"this","that","did","deed","them!","a"};
        System.out.println(minimumCharactersForWords(words));
    }
}
