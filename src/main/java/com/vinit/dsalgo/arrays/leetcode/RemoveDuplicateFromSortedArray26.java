package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArray26 {

    public static int removeDuplicates(int[] nums) {
        int insertIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIdx] = nums[i];
                insertIdx++;
            }
        }
        return insertIdx;
    }

    public static void main(String[] args) {
//        int[] n = {1,1,2};
        int[] n = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(n));
    }
}
