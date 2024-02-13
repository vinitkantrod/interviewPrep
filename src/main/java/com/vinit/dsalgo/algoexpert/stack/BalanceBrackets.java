package com.vinit.dsalgo.algoexpert.stack;

import java.util.*;

public class BalanceBrackets {

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        for (char c : str.toCharArray()) {
            if (set.contains(c)) stack.push(c);
            else {
                if (c == ']') {
                    if (!stack.empty() && stack.peek() == '[') stack.pop();
                    else return false;
                }
                if (c == '}') {
                    if (!stack.empty() && stack.peek() == '{') stack.pop();
                    else return false;
                }
                if (c == ')') {
                    if (!stack.empty() && stack.peek() == '(') stack.pop();
                    else return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("(((((({{{{{[[[[[([)])]]]]]}}}}}))))))"));
        System.out.println(balancedBrackets(")[]}"));
    }
}
