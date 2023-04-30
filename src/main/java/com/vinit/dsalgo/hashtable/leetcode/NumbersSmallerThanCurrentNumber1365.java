package com.vinit.dsalgo.hashtable.leetcode;

import java.util.Arrays;

public class NumbersSmallerThanCurrentNumber1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < nums.length; i++) {
            int c = 0;
            for (int j = 0; j < nums.length; j++) if (i != j && nums[j] < nums[i]) c++;
            res[i] = c;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] n = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(n)));
    }
}
