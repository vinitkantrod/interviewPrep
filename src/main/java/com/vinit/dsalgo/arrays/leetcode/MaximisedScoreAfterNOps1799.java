package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximisedScoreAfterNOps1799 {

    /**
     * Solution link: https://leetcode.com/problems/maximize-score-after-n-operations/solutions/3521564/easy-c-java-code-step-by-step-explanation/?languageTags=java
     */
    int[] dp;

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int dfs(List<Integer> nums, int state, int current) {
        if (current == 0) return 0;
        if (dp[state] != 0) return dp[state];
        int result = 0, n = nums.size();

        List<Integer> total = new ArrayList<>();

        //index of nums elements that are not used yet
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                total.add(i);
            }
        }

        //mark total[i] and total[j] as used with bit compression technique
        for (int i = 0; i < total.size(); i++) {
            for (int j = i + 1; j < total.size(); j++) {
                result = Math.max(result, gcd(nums.get(total.get(i)), nums.get(total.get(j))) * current
                        + dfs(nums, (state & (~(1 << total.get(i)) & (~(1 << total.get(j))))), current - 1));
            }
        }

        dp[state] = result;
        return result;
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        dp = new int[1 << n];
        Arrays.fill(dp, 0);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return dfs(list, (1 << n) - 1, n / 2);
    }
}
