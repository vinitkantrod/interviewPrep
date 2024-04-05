package com.vinit.dsalgo.assessment.random;

import java.util.Arrays;

public class TwoNArray {

    public static int[] shuffle(int[] nums, int n) {
        int left = 0;
        int right = left + n;
        int[] res = new int[nums.length];
        int k = 0;
        while (right < nums.length) {
            res[k++] = nums[left++];
            res[k++] = nums[right++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(shuffle(n, 3)));
    }
}
