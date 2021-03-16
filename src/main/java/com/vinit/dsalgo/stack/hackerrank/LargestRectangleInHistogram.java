package com.vinit.dsalgo.stack.hackerrank;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static long largestRectangle(int[] h) {
        if (h.length == 0) return 0;
        if (h.length == 1) return h[0];

        long max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);
        for (int i = 1; i < h.length; i++) {
            int curr = h[i];
//            System.out.println("curr: " + curr);
            if (curr >= h[stack.peek()]) {
                stack.add(i);
//                System.out.println("peek of stack: " + stack.peek());
            } else {
                while (!stack.empty() && curr < h[stack.peek()]) {
                    int temp = h[stack.pop()];
//                    System.out.println("temp: " + temp);
                    if (stack.empty()) {
                        max = Math.max(max, temp*i);
//                        System.out.println("Empty stack max: " + max);
                    } else {
                        max = Math.max(max, temp * (i - stack.peek() - 1));
//                        System.out.println("i: " + i + ", peek: " + stack.peek() + "Stack max: " + max);
                    }
                }
                stack.add(i);
            }
        }
//        System.out.println("=====");
//        System.out.println("peek: " + stack.peek());
        if (!stack.empty()) {
            int i = h.length;
            while (!stack.empty()) {
                int temp = h[stack.pop()];
//                System.out.println("temp: " + temp);
                if (stack.empty()) {
                    max = Math.max(max, temp*i);
//                    System.out.println("Empty stack max: " + max);
                } else {
                    max = Math.max(max, temp * (i - stack.peek() - 1));
//                    System.out.println("i: " + i + ", peek: " + stack.peek() + "Stack max: " + max);
                }
            }
        }
        return max;
    }
    public static void main(String args[]) {
        System.out.println(largestRectangle(new int[]{11, 11, 10, 10, 10}));
    }
}
