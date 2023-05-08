package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArrayTwo80 {

    public static int removeDuplicates(int[] nums) {
        int firstOccurance = Integer.MIN_VALUE;
        int secondOccurance = Integer.MIN_VALUE;
        int j = 0;
        int updateIdx = 0;
        while (j < nums.length) {
            if (nums[j] != firstOccurance) {
                firstOccurance = nums[j];
                nums[updateIdx++] = nums[j];
            } else if (nums[j] == firstOccurance && nums[j] != secondOccurance) {
                secondOccurance = nums[j];
                nums[updateIdx++] = nums[j];
            }
            j++;
//            System.out.print("j: " + j);
//            System.out.println(", first: " + firstOccurance + ", second: " + secondOccurance);
//            System.out.println(Arrays.toString(nums));
        }
        return updateIdx;
    }

    public static void main(String[] args) {
        int[] n = {1,1,1,2,2,2,2,2,2,3};
        System.out.println(removeDuplicates(n));
    }
}
