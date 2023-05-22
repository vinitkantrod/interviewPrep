package com.vinit.dsalgo.design.leetcode;

import java.util.Arrays;

class NumArray {
    int[] array;
    public NumArray(int[] nums) {
        array = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = array[i] + nums[i];
        }

        System.out.println(Arrays.toString(array));
    }

    public int sumRange(int left, int right) {
        return array[right + 1] - array[left];
    }
}
public class RangeSumQueries303 {

}
