package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfAllSubsetXORTotals {

    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        allSubset(nums, 0, list, new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.asList(list.get(i)));
        }
        return 0;
    }

    public static void allSubset(int[] nums, int index, List<List<Integer>> list, List<Integer> tempList) {
        if (index == nums.length) return;
        list.add(new ArrayList<>(tempList));
        tempList.add(nums[index]);
        allSubset(nums, index + 1, list, tempList);
        tempList.remove(tempList.size() - 1);
    }
    public static void main(String[] args) {
        int[] n = {1,3};
        System.out.println(subsetXORSum(n));
    }
}
