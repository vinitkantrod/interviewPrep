package com.vinit.dsalgo.stack.narasimha_karumanchi_book;

import java.util.Stack;

public class ReverseStack {


    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) return;
        int temp = stack.pop();
        System.out.println("temp: " + temp);
        reverse(stack);
        insertAtBottom(stack, temp);
    }

    public static void insertAtBottom(Stack<Integer> stack, int data) {
        System.out.println("stack: " + stack.toString() + ", data: " + data);
        if (stack.empty()) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    public static void traverse(Stack<Integer> stack) {
        System.out.print("Stack -> [ ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " | ");
        }
        System.out.println(" ] ");
    }
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        traverse(stack);
    }
}
