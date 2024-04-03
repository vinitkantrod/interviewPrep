package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO
public class ArithematicSliceSubsequence446 {

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer> diffCount = new HashMap<>();
        combination(1, nums, new ArrayList<Integer>(), diffCount);
        return 0;
    }
    private static void combination(int idx, int[] nums, List<Integer> currArr, Map<Integer, Integer> countMap) {
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            int lastEle = currArr.get(currArr.size() - 1);
            int diff = nums[i] - lastEle;
            currArr.add(nums[i]);
            combination(i + 1, nums, currArr, countMap);
            currArr.remove(currArr.size() - 1);
            combination(i + 1, nums, currArr, countMap);
        }
    }
}
