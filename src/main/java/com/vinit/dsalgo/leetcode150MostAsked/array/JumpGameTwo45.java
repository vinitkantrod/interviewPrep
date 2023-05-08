package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;
import java.util.Map;

public class JumpGameTwo45 {

    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i);
            if (i == nums.length) return memo[i];
            int newVal = i + nums[i];
            System.out.println(", newVal: " + newVal);
            int k = i;
            while (k < nums.length && k <= newVal) {
                memo[k] = Math.min(memo[k], memo[i] + 1);
                k++;
            }
            System.out.println(Arrays.toString(memo));
        }
        return memo[nums.length - 1];
    }

    public static void main(String[] args) {
//        int[] n = {2,3,1,1,4};
        int[] n = {2,3,0,1,4};
        System.out.println(jump(n));
    }
}
