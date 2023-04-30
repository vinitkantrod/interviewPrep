package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class CountPairsOfSimiliarThings2506 {

    public static int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Set<String> set = new TreeSet<>();
            String w = words[i];
            for (char c : w.toCharArray()) set.add(String.valueOf(c));
            String s = String.join("",set);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        System.out.println(map);
        for (Map.Entry m : map.entrySet()) {
            int v = (int)m.getValue();
            if (v >= 2) count += ((v * (v - 1)) / 2);
        }
        return count;
    }

    public static void main(String[] args) {
//        String[] w = {"aba","aabb","abcd","bac","aabc"};
        String[] w = {"aabb","ab","ba","aba","baaa", "ab", "ab"};
//        String[] w = {"zgtzytjkre","jjzdbxyutj","umghhnlihq","mdxjukhqsm","mqdplhuvqr","xpdhateywu","ugedwkxapc","vjpryhictr"};
        System.out.println(similarPairs(w));
    }
}
