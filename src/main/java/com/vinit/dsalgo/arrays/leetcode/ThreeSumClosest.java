package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.Map;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] num = {3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1};
        System.out.println(threeSumClosest(num, 3));
    }
}
