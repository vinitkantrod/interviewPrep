package com.vinit.dsalgo.backtrack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
