package com.vinit.dsalgo.stack.leetcode;

import java.util.Stack;

public class BackspaceStringCompare844 {

    public static boolean backspaceCompare(String s, String t) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!s1.empty()) {
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!s2.empty()) {
                    s2.pop();
                }
            } else {
                s2.push(c);
            }
        }

        while (!s1.empty() && !s2.empty()) {
            char c1 = (char)s1.pop();
            char c2 = (char)s2.pop();
            if (c1 != c2) return false;
        }

        if (!s1.empty() || !s2.empty()) return false;

        return true;
    }
    public static void main(String[] args){
        System.out.println(backspaceCompare("ad#c", "ab#c"));
    }
}
