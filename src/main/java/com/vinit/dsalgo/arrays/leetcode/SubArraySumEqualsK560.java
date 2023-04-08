package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualsK560 {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) result++;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
        }
        return result;
    }
    public static void main(String[] args) {
//        int[] nums = {1,1,1}; // k = 2
//        int[] nums = {9,4,20,3,10,5}; // k = 33
//        int[] nums = {0,0,0,0,0,0,0,0,0,0}; // k = 0
        int[] nums = {0,0,0,0,0}; // k = 0
        System.out.println(subarraySum(nums, 0));
    }
}
