package com.vinit.dp.mergeIntervals;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        int[][] memo = new int[n][n];
        return dp(memo, newNums, 1, n - 2);
    }

    private static int dp(int[][] memo, int[] newNums, int left, int right) {
        if (right - left < 0) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int result = 0;
        for (int i = left; i <= right; i++) {
            int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
            int remaining = dp(memo, newNums, left, i - 1) + dp(memo, newNums, i + 1, right);

            result = Math.max(result, gain + remaining);
        }
        memo[left][right] = result;
        return result;
    }
}
