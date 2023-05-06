package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckIfNumberHasEqualDigitCount2283 {

    public static boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) map.put(i, (num.charAt(i) - '0'));
        System.out.println(map);
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            map.put(val, map.getOrDefault(val, 0) - 1);
        }
        System.out.println(map);
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(digitCount("030"));
    }
}
