package com.vinit.dsalgo.arrays.leetcode;

public class BuildArrayFromPermutation1920 {

//    public int[] buildArray(int[] nums) {
//        int[] res= new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = nums[nums[i]];
//        }
//        return res;
//    }

    // O(1) Space Complexity
    public int[] buildArray(int[] nums) {
        aPermutation(nums,0);

        return nums;
    }

    void aPermutation(int[] nums,int start) {
        if (start < nums.length) {
            int temp = nums[start];
            int result = nums[temp];
            aPermutation(nums, start + 1);
            nums[start] = result;
        }
    }
}
