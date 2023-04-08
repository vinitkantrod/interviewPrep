/*
https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1

 */
package com.vinit.dsalgo.leetcode75.level1.prefix_sum;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
//        if (nums.length == 0) return -1;
//        int leftSum = 0;
//        int rightSum = 0;
//        for (int i = 1; i < nums.length; i++) {
//            rightSum += nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (leftSum == rightSum) return i;
//            leftSum += nums[i];
//            if (i + 1 == nums.length) rightSum = 0;
//            else rightSum -= nums[i+1];
//        }
//        return -1;

        int sum = 0;
        for(int i : nums) sum += i;
        int leftSum = 0;
        int rightSum = sum;
        for(int i = 0; i < nums.length; i++){
            rightSum -= nums[i];
            if(rightSum == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {1,2,3};
//        int[] nums = {2,1,-1};
//        int[] nums = {1,-2,1,6};
//        int[] nums = {1,2,3,4};
//        int[] nums = {100};
        int[] nums = {0,1};
//        int[] nums = {0,0};
//        int[] nums = {1, 0};
        System.out.println(pivotIndex(nums));
    }
}
