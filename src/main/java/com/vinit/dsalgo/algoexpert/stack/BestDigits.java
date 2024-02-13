package com.vinit.dsalgo.algoexpert.stack;

import java.util.Collections;
import java.util.Stack;
import java.util.WeakHashMap;

public class BestDigits {

    public static String bestDigits(String number, int numDigits) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            Character ch = number.charAt(i);
            while (numDigits > 0 && !stack.empty() && ch > stack.peek()) {
                numDigits--;
                stack.pop();
            }
            stack.push(ch);
        }
        while (numDigits > 0) {
            numDigits--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(bestDigits("462839", 2));
        System.out.println(bestDigits("191", 1));
        System.out.println(bestDigits("839", 1));
    }
}
