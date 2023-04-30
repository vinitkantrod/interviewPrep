package com.vinit.dsalgo.hashtable.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingsAndRods2103 {

    public static int countPoints(String rings) {
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 48; i < 58; i++) {
            map.put(i, new ArrayList<>());
        }
        System.out.println(map);
        int points = 0;
        for (int i = 0 ; i < rings.length() - 1; i=i+2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1);
            System.out.println(rod + " - " + color);
            List<Character> c = map.get(rod);
            System.out.println(c);
            if (c.size() == 0) c.add(color);
            else if (!c.contains(color)) c.add(color);
            map.put(rod, c);
            System.out.println(map);
        }
        for (Map.Entry m : map.entrySet()) {
            List<Character> c = (List<Character>) m.getValue();
            if (c.size() == 3) points++;
        }
        return points;
    }

    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }
}
