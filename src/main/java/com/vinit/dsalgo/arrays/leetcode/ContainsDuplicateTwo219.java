package com.vinit.dsalgo.arrays.leetcode;

public class ContainsDuplicateTwo219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && j >= (i - k); j--) {
                System.out.println(i + " - " + j);
                if (j >= 0 && nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
