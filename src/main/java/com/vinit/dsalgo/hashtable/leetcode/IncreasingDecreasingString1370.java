package com.vinit.dsalgo.hashtable.leetcode;


import java.util.*;

public class IncreasingDecreasingString1370 {

    public static String sortString(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        System.out.println(map);
        List<List<Character>> pair = new ArrayList<>();
        for (Map.Entry m : map.entrySet()) {
            List<Character> c = new ArrayList<>(Arrays.asList((char) m.getKey(), (char) ((int)m.getValue() + '0') ));
            pair.add(c);
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            for (int i = 0; i < pair.size(); i++) {
                int v= pair.get(i).get(1);
                if (v > 48) {
                    sb.append(pair.get(i).get(0));
                    pair.get(i).set(1, (char) (v - 1));
                    n--;
                }
            }
            if (n == 0) break;
            for (int i = pair.size() - 1; i >= 0; i--) {
                int v= pair.get(i).get(1);
                if (v > 48) {
                    sb.append(pair.get(i).get(0));
                    pair.get(i).set(1, (char) (v - 1));
                    n--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortString("aaabbbccc"));
        System.out.println(sortString("rat"));
        System.out.println(sortString("leetcode"));
    }
}
