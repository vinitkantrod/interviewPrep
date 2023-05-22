package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.*;

public class CombinationSumFour377 {

    public int combinationSum4(int[] nums, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) set.add(nums[i]);
//        int[] num = new int[set.size()];
//        int j = 0;
//        for (int i : set) num[j++] = i;
//        Arrays.sort(num);
//        findCombination(num, ans, temp, 0, target);
//        return ans.size();

        // minor optimization
        // Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int combSum = 1; combSum < target + 1; ++combSum) {
            for (int num : nums) {
                if (combSum - num >= 0)
                    dp[combSum] += dp[combSum - num];
                // minor optimizaton, early stopping
                 else
                     break;
            }
        }
        return dp[target];
    }

    public static void findCombination(int[] num, List<List<Integer>> ans,
                                                List<Integer> temp, int index, int sum) {
        if (sum == 0) {
            List<Integer> t = new ArrayList<>(temp);
            ans.add(t);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (sum - num[i] >= 0) {
                temp.add(temp.size(), num[i]);
                findCombination(num, ans, temp, i, sum - num[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
