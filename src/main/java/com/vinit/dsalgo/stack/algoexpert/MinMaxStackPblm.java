package com.vinit.dsalgo.stack.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStackPblm {

    static class MinMaxStack {
        List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
        List<Integer> stack = new ArrayList<Integer>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            Map<String, Integer> newMinMax = new HashMap<String, Integer>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax = minMaxStack.get(minMaxStack.size() - 1);
                newMinMax.put("min", Math.min(number, lastMinMax.get("min")));
                newMinMax.put("max", Math.max(number, lastMinMax.get("max")));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }

    public static void main(String args[]) {

    }
}
