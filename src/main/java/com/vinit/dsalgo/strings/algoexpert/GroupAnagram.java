package com.vinit.dsalgo.strings.algoexpert;

import java.util.*;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String[] sortedString = sortString(words.get(i));
            if (anagramMap.containsKey(sortedString[0])) {
                anagramMap.get(sortedString[0]).add(sortedString[1]);
            } else {
                anagramMap.put(sortedString[0], new ArrayList<>(Arrays.asList(sortedString[1])));
            }
        }
        for (Map.Entry e : anagramMap.entrySet()) {
            result.add((ArrayList) e.getValue());
        }
//        System.out.println(anagramMap);
        return result;
    }

    public static String[] sortString(String word) {
        String[] w = {"", word};
        Character[] charArray = new Character[word.length()];
        for (int i = 0; i < word.length(); i++) {
            charArray[i] = word.charAt(i);
        }
        Arrays.sort(charArray, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.compare(Character.toLowerCase(o1), Character.toLowerCase(o2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : charArray) {
            sb.append(c.charValue());
        }
        w[0] = sb.toString();
        return w;
    }

    public static void main(String args[]) {
        List<String> words = new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "lofp"));
        groupAnagrams(words);
    }
}
