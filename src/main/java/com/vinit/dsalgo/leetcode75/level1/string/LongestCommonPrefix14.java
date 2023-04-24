package com.vinit.dsalgo.leetcode75.level1.string;

import java.util.Arrays;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
//        String res = "";
//        if (strs.length == 1) return strs[0];
//        res = strs[0];
//        if (res.equals("")) return res;
//        System.out.println("initial: " + res);
//        for (int i = 1; i < strs.length; i++) {
//            System.out.println("string: " + strs[i]);
//            int j = 0;
//            for (; j < strs[i].length(); j++) {
//                System.out.println("----");
//                if (strs[i].charAt(j) != res.charAt(j)) break;
//            }
//            System.out.println("j: " + j);
//            if (j == 0) return "";
//            res = res.substring(0, j);
//        }
//        System.out.println("res: " + "".charAt(0));
//        return res;

        // LC code
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
    public static void main(String[] args) {
        String[] strs = {"flower", ""}; //, "flight"};
//        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
