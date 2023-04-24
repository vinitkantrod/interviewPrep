package com.vinit.dsalgo.stack.leetcode;

import java.util.Stack;

public class CrawlerLogFolder1598 {

    // For each string,
    //  if it contains 2 dot before '/' then pop from stack
    //  if it contains only one . then do nothing
    // else just count++ number in stack and return top element once traversal is finish.
    public static int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs) {
            // if 1, then pop
            // if 2, then do nothing
            // if 3 then push count to stack
            int ops = decodeString(s);
            switch (ops) {
                case 1:
                    if (count > 0) count--;
                    break;
                case 2:
                    break;
                default:
                    count++;
                    break;

            }
        }
        return count;
    }

    public static int decodeString(String s) {
        int dotCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '.') {
                dotCount++;
                if (dotCount == 2) return 1;
            } else if (c != '/') {
                return 3;
            } else {
                return 2;
            }
        }
        return 2;
    }
    public static void main(String[] args) {
        String[] s = {"d1/", "d2/", "./", "../", "d3/", "../", "./"};
        System.out.println(minOperations(s));
    }
}
