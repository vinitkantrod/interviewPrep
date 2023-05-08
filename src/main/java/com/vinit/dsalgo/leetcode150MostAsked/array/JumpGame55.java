package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class JumpGame55 {

    public static boolean canJump(int[] nums) {
//        if (nums.length == 1) return true;
//        Boolean[] memo = new Boolean[nums.length];
//        Arrays.fill(memo, false);
//        memo[0] = true;
//        for (int i = 0; i < nums.length; i++) {
//            if (memo[i]) {
//                int val = nums[i];
//                System.out.println(val);
//                for (int j = i; j <= (i + val); j++) {
//                    if (j < nums.length && !memo[j]) memo[j] = true;
//                    //                if (j == nums.length - 1) return true;
//                }
//                System.out.println(i + " = " + Arrays.toString(memo));
//            }
//        }
//        return memo[nums.length - 1];

        if(nums.length <= 1){
            return true;
        }
        int stepsleft = nums[0];
        int index = 1;
        while(stepsleft > 0){
            if (index == nums.length-1){
                return true;
            }
            stepsleft = Math.max(stepsleft-1, nums[index]);
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] n = {2,3,1,1,4};
//        int[] n = {3,2,1,0,4};
        System.out.println(canJump(n));
    }
}
