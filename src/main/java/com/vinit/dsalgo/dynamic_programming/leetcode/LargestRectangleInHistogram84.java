package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public int largestRectangleArea(int[] heights) {
        // Time Limit Exceeded
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int minHeight = Integer.MAX_VALUE;
//            for (int j = i; j < heights.length; j++) {
//                minHeight = Math.min(minHeight, heights[j]);
//                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
//            }
//        }
//        return maxArea;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currWidth * currHeight);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currWidth * currHeight);
        }
        return maxArea;
    }
}
