package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget2824 {

    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> r = new ArrayList<>(Arrays.asList(-1,1,2,3,1));
        System.out.println(countPairs(r, 2));
    }
}
