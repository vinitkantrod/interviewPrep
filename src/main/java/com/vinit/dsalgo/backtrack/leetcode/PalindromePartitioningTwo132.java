package com.vinit.dsalgo.backtrack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PalindromePartitioningTwo132 {

    static private Boolean[][] memoPalindrome;
    static private Integer[] memoCuts;
    public static int minCut(String s) {
        List<List<String>> list = new ArrayList<>();
        memoCuts = new Integer[s.length()];
        memoPalindrome = new Boolean[s.length()][s.length()];
        return findMinimum(s, 0, s.length() - 1, s.length() - 1);
//        backtrack(list, new ArrayList<>(), s, 0);
//        int minCut = Integer.MAX_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).size() - 1 < minCut) minCut = list.get(i).size() - 1;
//        }
//        return minCut;
    }

    public static int findMinimum(String s, int start, int end, int minCut) {
        if (start == end || isPalindrome(s, start, end)) return 0;
        if (memoCuts[start] != null) return memoCuts[start];
        for (int i = start; i < end; i++) {
            if (isPalindrome(s, start, i)) {
                minCut = Math.min(minCut, 1 + findMinimum(s, i + 1, end, minCut));
            }
        }
        return memoCuts[start] = minCut;
    }
    public static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        // check for results in memoPalindrome
        if (memoPalindrome[start][end] != null) {
            return memoPalindrome[start][end];
        }
        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
                && isPalindrome(s, start + 1, end - 1);
    }

//    public static Boolean isPalindrome(String s, int low, int high) {
//        while (low < high) {
//            if (s.charAt(low++) != s.charAt(high--)) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(minCut("ababababababababababababcbabababababababababababa"));
    }
}
