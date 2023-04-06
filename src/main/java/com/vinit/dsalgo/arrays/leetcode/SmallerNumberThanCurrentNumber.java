/**
 * Link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class SmallerNumberThanCurrentNumber {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] tempRes = new int[101];
        int[] minCount = new int[101];
        Arrays.fill(tempRes, 0);
        for (int i = 0; i < nums.length; i++) {
            tempRes[nums[i]] = tempRes[nums[i]] + 1;
        }
        int min = 0;
        minCount[0] = 0;
        for (int i = 1; i < tempRes.length; i++) {
            minCount[i] = tempRes[i-1] + minCount[i-1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = minCount[nums[i]];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3, 10};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
}
