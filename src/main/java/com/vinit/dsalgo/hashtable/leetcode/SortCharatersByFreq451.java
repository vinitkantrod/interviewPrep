package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharatersByFreq451 {

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> sortedMap = sortMapByValueDescending(map);
        System.out.println(sortedMap);
        StringBuffer sb = new StringBuffer();
        for (Character c : map.keySet()) {
            sb.append( String.valueOf(c).repeat(map.get(c)));
            System.out.println(sb.toString());
        }
        return sb.toString();
    }
    public static Map<Character, Integer> sortMapByValueDescending(Map<Character, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tttrrrrree"));
    }
}
