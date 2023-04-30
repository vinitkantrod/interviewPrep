package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsWithAbsDiff2006 {

    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
//        System.out.println(map);
        int count = 0;
        for (int i = 0 ; i < nums.length; i++) {
            System.out.println(nums[i] + ", k: " + k + " = " + (nums[i] - k));
            if (map.containsKey(nums[i] - k)) count += map.get(nums[i] - k);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] n = {3,2,1,5,4};
        System.out.println(countKDifference(n, 2));
    }
}
