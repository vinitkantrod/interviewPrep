package com.vinit.dsalgo.algoexpert.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinMaxStackConstruction {

    static class Pair {
        int value;
        int min;
        int max;
        public Pair(int val, int min, int max) {
            this.value = val;
            this.max = max;
            this.min = min;
        }
        public String toString() {
            return this.value + " - " + this.min + " - " + this.max;
        }
    }
    static class MinMaxStack {
        List<Pair> list = new LinkedList<>();
        public int peek() {
            // Write your code here.
            if (!list.isEmpty()) {
                return list.get(0).value;
            }
            return -1;
        }

        public int pop() {
            // Write your code here.
            Pair p = list.remove(0);
            return p.value;
        }

        public void push(Integer number) {
            // Write your code here.
            Pair newPair = new Pair(number, number, number);
            if (!list.isEmpty()) {
                Pair p = list.get(0);
                newPair.min = Math.min(newPair.min, p.min);
                newPair.max = Math.max(newPair.max, p.max);
                list.add(0, newPair);
            } else {
                list.add(0, newPair);
            }
            System.out.println(Arrays.asList(list.toString()));
        }

        public int getMin() {
            // Write your code here.
            return list.get(0).min;

        }

        public int getMax() {
            // Write your code here.
            return list.get(0).max;
        }
    }

    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();
        stack.push(5);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        stack.push(7);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
    }
}
