package com.vinit.dsalgo.strings.leetcode;

import java.util.Stack;

public class MakeTheStringGreat1544 {

    public static String makeGood(String s) {
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (Math.abs( s.charAt(i) - s.charAt(i + 1)) == 32 ) {
//                return makeGood(s.substring(0, i) + s.substring(i + 2));
//            }
//        }
//        return s;

        // stack
        Stack<Character> stack = new Stack<>();

        // Iterate over 's'.
        for (char currChar : s.toCharArray()) {
            // If the current character make a pair with the last character in the stack,
            // remove both of them. Otherwise, we the add current character to stack.
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - currChar) == 32)
                stack.pop();
            else
                stack.add(currChar);
        }

        // Returns the string concatenated by all characters left in the stack.
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack)
            ans.append(currChar);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("aBbACc"));
    }
}
