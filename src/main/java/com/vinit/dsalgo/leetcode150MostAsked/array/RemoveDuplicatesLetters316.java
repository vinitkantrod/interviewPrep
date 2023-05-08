package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.*;

public class RemoveDuplicatesLetters316 {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.empty() && c < stack.peek() && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                stack.push(c);
                set.add(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.capacity());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }
}
