package com.vinit.dsalgo.stack.leetcode;

import java.util.Stack;

public class RemoveOutermostParanthesis1021 {

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count > 1) sb.append(s.charAt(i));
            } else {
                count--;
                if (count > 0) sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
