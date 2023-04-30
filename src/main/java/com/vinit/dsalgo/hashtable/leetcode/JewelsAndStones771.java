package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones771 {

    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Boolean> stoneMap = new HashMap<>();
        for (char c : jewels.toCharArray()) {
            if (!stoneMap.containsKey(c)) stoneMap.put(c, true);
        }
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (stoneMap.containsKey(c)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbb";
        System.out.println(numJewelsInStones(j, s));
    }
}
