package com.vinit.dsalgo.arrays.leetcode;

public class FirstPalindromicStringInArray2108 {

    public static String firstPalindrome(String[] words) {
        for (String s : words) if (isPalindrome(s)) return s;
        return "";
    }
    public static Boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
