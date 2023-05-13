package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StepsToMakeArrayNonDecreasing2289 {

    public static int totalSteps(int[] nums) {
        int step = 0;
        Stack<int[]> stack = new Stack<>();
        System.out.println("pushing: " + nums[0] + ", temp: " + 0);
        stack.push(new int[]{nums[0], 0});
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            while (!stack.empty() && stack.peek()[0] <= nums[i]) {
                temp = Math.max(temp, stack.peek()[1]);
                stack.pop();
            }
            if (!stack.empty()) {
                temp += 1;
            } else {
                temp = 0;
            }
            step = Math.max(step, temp);
            System.out.println("pushing: " + nums[i] + ", temp: " + temp);
            stack.push(new int[]{nums[i], temp});
        }
        return step;
    }

    public static void main(String[] args) {
        int[] n = {5,3,4,4,7,3,6,11,8,5,11};
        System.out.println(totalSteps(n));
    }
}
