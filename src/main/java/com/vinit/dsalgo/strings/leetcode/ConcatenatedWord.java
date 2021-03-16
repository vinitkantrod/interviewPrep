package com.vinit.dsalgo.strings.leetcode;

import java.util.*;

public class ConcatenatedWord {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Map<String, Boolean> stringMap = new HashMap<>();
        for (String s : words) {
            stringMap.put(s, true);
        }
        System.out.println(stringMap);
        for (String s : words) {
            System.out.println("checking for string " + s);
            String newString = "";
            int stringCount = 0;
            int i = 0;
            while (i < s.length()) {
                newString += s.charAt(i);
                System.out.println("char: " + s.charAt(i) + ", newString: " + newString);
                if (stringMap.containsKey(newString)) {
                    stringCount++;
                    newString = "";
                }
                i++;
            }
            if (stringCount >= 2) {
                result.add(s);
            }
        }
        return result;
    }
    public static void main(String args[]) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(Arrays.toString(findAllConcatenatedWordsInADict(words).toArray()));
    }
}
