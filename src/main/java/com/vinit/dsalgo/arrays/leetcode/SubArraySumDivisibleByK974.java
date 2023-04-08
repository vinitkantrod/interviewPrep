package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK974 {

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> reminderCount = new HashMap<>();
        int result = 0;
        int sum = 0;
        reminderCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reminder = (sum % k + k) % k;
            if (reminderCount.containsKey(reminder)) {
                result += reminderCount.get(reminder);
            }
            reminderCount.put(reminder, reminderCount.containsKey(reminder) ? reminderCount.get(reminder) + 1 : 1);
        }
        System.out.println(reminderCount);
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,0,-2,-3,1};
        int[] nums = {-1, 2, 9};
        System.out.println(subarraysDivByK(nums, 2));
    }
}
