package com.vinit.dsalgo.leetcode75.level1.string;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr2 < t.length()) {
            if (ptr1 < s.length() && s.charAt(ptr1) == t.charAt(ptr2)) {
                ptr1++;
            }
            ptr2++;
        }
        return ptr1 == s.length() ? true : false;
    }

    public static void main(String[] args) {
//        String s = "abc";
//        String t = "ahcbgd";
        String s = "";
        String t = "";
        System.out.println(isSubsequence(s, t));
    }
}
