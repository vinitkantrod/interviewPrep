package com.vinit.dsalgo.algoexpert.stack;

import java.util.*;

public class ReversePolishNotation {

    public static int reversePolishNotation(String[] tokens) {
        // Write your code here.
        Stack<String> stack = new Stack<>();
        int i = 0;
        Set<String> set = new HashSet<>(Arrays.asList("+","-","*","/"));
        while (i < tokens.length) {
            if (set.contains(tokens[i])) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int res;
                switch (tokens[i]) {
                    case "+":
                        res = first + second;
                        break;
                    case "-":
                        res = first - second;
                        break;
                    case "*":
                        res = first * second;
                        break;
                    default:
                        res = first / second;
                        break;
                }
                stack.push(String.valueOf(res));
                System.out.println(List.of(stack));
            } else {
                stack.push(tokens[i]);
            }
            i++;
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"50","3","17","+","2","-","/"};
        System.out.println(reversePolishNotation(tokens));
    }
}
