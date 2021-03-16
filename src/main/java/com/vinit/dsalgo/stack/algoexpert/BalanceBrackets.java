package com.vinit.dsalgo.stack.algoexpert;

import java.util.Stack;

public class BalanceBrackets {

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Stack<Character> stack = new Stack<Character>();
        if (str.length() == 0) return true;
        int i = 0;
        while (i < str.length()) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase("(") ||
                    String.valueOf(str.charAt(i)).equalsIgnoreCase("[") ||
                    String.valueOf(str.charAt(i)).equalsIgnoreCase("{") ) {
                stack.push(str.charAt(i));
            } else if (String.valueOf(str.charAt(i)).equalsIgnoreCase(")") ) {
                if (!stack.empty() && String.valueOf(stack.peek()).equalsIgnoreCase("(")) {
                    stack.pop();
                } else break;
            } else if (String.valueOf(str.charAt(i)).equalsIgnoreCase("]") ) {
                if (!stack.empty() && String.valueOf(stack.peek()).equalsIgnoreCase("[")) {
                    stack.pop();
                } else break;
            } else if (String.valueOf(str.charAt(i)).equalsIgnoreCase("}") ) {
                if (!stack.empty() && String.valueOf(stack.peek()).equalsIgnoreCase("{")) {
                    stack.pop();
                } else break;
            }
            i++;
        }
        if (stack.empty() && i == str.length()) return true;
        else System.out.println(stack.peek());
        return false;
    }
    public static void main(String args[]) {
        System.out.println(balancedBrackets(")[]}"));
    }
}
