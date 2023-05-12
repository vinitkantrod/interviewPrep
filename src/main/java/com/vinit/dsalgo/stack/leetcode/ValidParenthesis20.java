package com.vinit.dsalgo.stack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) stack.push(c);
            else {
                if (!stack.empty()) {
                    if (stack.peek() != map.get(c)) return false;
                    else stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
