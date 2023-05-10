package com.vinit.dsalgo.leetcode75.level1.design;

import java.util.*;

class MinStack {

    Stack<int[]> stack = new Stack<>();
    public MinStack() {
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }
        int currMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(currMin, val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
public class MinStack155 {

}
