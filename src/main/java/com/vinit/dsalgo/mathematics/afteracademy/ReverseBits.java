package com.vinit.dsalgo.mathematics.afteracademy;

import java.util.Stack;

public class ReverseBits {

    public static int reverseBits(int num) {
        // write your awesome code here
        String s = Integer.toBinaryString(num);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        String resString = "";
        while (!stack.empty()) {
            resString += String.valueOf(stack.pop());
        }
        return Integer.parseInt(resString, 2);
    }

    public static void main(String args[]) {
        System.out.println(reverseBits(10));
    }
}
