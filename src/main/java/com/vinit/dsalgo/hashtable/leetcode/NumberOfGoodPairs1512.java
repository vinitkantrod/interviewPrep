package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class NumberOfGoodPairs1512 {

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            } else {
                List<Integer> lst = map.get(nums[i]);
                for (int j = 0; j < lst.size();j++) {
                    if (j < i) count++;
                }
                lst.add(i);
                map.put(nums[i], lst);
            }
        }
        return count;
    }
    public static void main(String[] args) {
//        int[] n = {1,2,3,1,1,3};
//        int[] n = {1,1,1,1};
        int[] n = {1,2,3};
        System.out.println(numIdenticalPairs(n));
    }
}
