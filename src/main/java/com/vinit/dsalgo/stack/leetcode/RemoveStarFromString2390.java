package com.vinit.dsalgo.stack.leetcode;

public class RemoveStarFromString2390 {


    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*') sb.append(c);
            else sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
}
