package com.vinit.dsalgo.strings.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindromeByConcatenatingTwoLetterWords2131 {

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Boolean central = false;
        int total = 0;
        for (int i = 0; i < words.length; i++) map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            String w = m.getKey();
            int countOfWord = m.getValue();
            if (w.charAt(0) == w.charAt(1)) {
                if (countOfWord % 2 == 0) {
                    total += countOfWord;
                } else {
                    total += countOfWord - 1;
                    central = true;
                }
            } else if (w.charAt(0) < w.charAt(1)) {
                String reverseWord = "" + w.charAt(1) + w.charAt(0);
                if (map.containsKey(reverseWord)) {
                    total += 2 * Math.min(countOfWord, map.get(reverseWord));
                }
            }
        }
        if (central) total++;
        return 2 * total;
    }

    public static void main(String[] args) {
//        String[] w = {"lc","cl","gg", "az", "za", "gf","wq","xs"};
//        String[] w = {"cc","ll","xx"};
//        String[] w = {"lc","cl","gg"};
//        String[] w = {"ab","ab","ba","ba"};
//        String[] w = {"ab","ty","yt","lc","cl","ab"};
        String[] w = {"lx","xl","cl","cc","cx","ll","lx","xc","xc","cx","ll","xx","xc","xx","xx","lx","lx","xx","cc","xx"};
        System.out.println(longestPalindrome(w));
    }
}
