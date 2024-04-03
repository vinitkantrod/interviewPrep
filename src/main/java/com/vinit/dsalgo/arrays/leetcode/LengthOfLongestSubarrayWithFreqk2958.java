package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithFreqk2958 {

    public static int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.get(nums[r]) > k) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] a= new int[]{1,4,4,3};
//        int[] a= new int[]{5,5,5,5};
//        int[] a= new int[]{1,2,3,1,2,3,1,2};
        int[] a= new int[]{1,2,2,1,3};
        System.out.println(maxSubarrayLength(a, 1));
    }
}
