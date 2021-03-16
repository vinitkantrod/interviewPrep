package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class ThreeNumberSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> indices = new ArrayList<>();
        int target = 0;
        for (int i = 0; i< nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int currentSum = nums[i] + nums[j] + nums[k];
                    if (currentSum == 0) {
                        indices.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++; k--;
                    }
                    else if (currentSum < target) j++;
                    else k--;
                }
            }
        }
        for (List<Integer> i : indices) {
            System.out.println(Arrays.toString(i.toArray()));
        }
        return indices;
    }

    public static void main(String args[]) {
        int[] num = {-1, 0, 1, 2, -1, -4};
//        int[] num = {0,0,0};
        threeSum(num);
    }
}
