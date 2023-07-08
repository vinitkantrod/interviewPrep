package com.vinit.dsalgo.arrays.leetcode;

import java.util.Stack;

public class DailyTemperature739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int temp = temperatures[currDay];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
