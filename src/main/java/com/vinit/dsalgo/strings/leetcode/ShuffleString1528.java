package com.vinit.dsalgo.strings.leetcode;

import java.util.Arrays;

public class ShuffleString1528 {

    public static String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0;i < s.length(); i++) ch[indices[i]] = s.charAt(i);
        return new String(ch);
    }

    public static void main(String[] args) {
        int[] n = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString("codeleet", n));
    }
}
