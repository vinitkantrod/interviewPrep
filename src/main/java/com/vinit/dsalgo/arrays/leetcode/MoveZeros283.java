package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class MoveZeros283 {

    public static void moveZeroes(int[] nums) {
        int insertedIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            while (insertedIdx < nums.length && nums[insertedIdx] != 0) insertedIdx++;
            if (insertedIdx == nums.length) break;
            if (i > insertedIdx && i < nums.length && nums[i] != 0 && nums[insertedIdx] == 0) {
                nums[insertedIdx] = nums[i];
                nums[i] = 0;
                insertedIdx++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
//        int[] n = {0,1,0,3,12};
        int[] n = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(n);
    }
}
