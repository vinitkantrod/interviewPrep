package com.vinit.dsalgo.leetcode75.level1.design;

import java.util.List;
import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty();
    }
}
public class ImplementQueueUsingStack232 {


}
