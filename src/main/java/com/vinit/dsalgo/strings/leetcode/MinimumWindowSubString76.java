package com.vinit.dsalgo.strings.leetcode;

import java.util.*;

public class MinimumWindowSubString76 {

    static class Pair {
        public int i;
        public char c;
        Pair(int _i, char _c) {
            i = _i;
            c = _c;
        }

        public String toString() {
            return "idx: " + i + ", char: " + c;
        }
    }
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
        System.out.println(dictT);
        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair> filteredS = new ArrayList<Pair>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair(i, c));
            }
        }
        System.out.println(Arrays.asList(filteredS));
        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = { -1, 0, 0 };

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).c;
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            System.out.println(formed + ", windowCount: " + windowCounts);
            System.out.println("l: " + l + ", r: " + r);
            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).c;

                // Save the smallest window until now.
                int end = filteredS.get(r).i;
                int start = filteredS.get(l).i;
                System.out.println("c: " + c + ", end: " + end + ", start: " + start);
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                System.out.println(Arrays.toString(ans));
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                System.out.println("formed: " + formed + " WC: " + windowCounts);
                l++;
            }
            r++;
            System.out.println("l: " + l + ", r: " + r);
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
