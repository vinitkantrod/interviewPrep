package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class MinimumNumberOfJump {
    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        int[] dp = new int[array.length];
        int i = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (i = 0; i < array.length; i++) {
            int count = 1;
            while (count <= array[i]) {
                if (i + count < array.length) {
                    dp[i + count] = Math.min(dp[i + count], dp[i] + 1);
                }
                count++;
            }
        }
        return dp[array.length - 1] == Integer.MAX_VALUE ? -1 : dp[array.length - 1];
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,2,1,2,3,7,1,1,1,0,0,0,0,0,0,0,0,3};
        System.out.println(minNumberOfJumps(a));
    }
}
