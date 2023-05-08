package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {

    public static int[] productExceptSelf(int[] nums) {
        // TC O(n) SC O(N)
//        int n = nums.length;
//        int[] res = new int[n];
//        int leftProduct[] = new int[n];
//        leftProduct[0] = 1;
//        int rightProduct[] = new int[n];
//        rightProduct[n - 1] = 1;
//        for (int i = 1; i < n;i++) {
//            leftProduct[i] = leftProduct[i - 1] * nums[i-1];
//        }
//        for (int i = n - 2; i >= 0;i--) {
//            rightProduct[i] = rightProduct[i + 1] * nums[i+1];
//        }
//        System.out.println(Arrays.toString(leftProduct));
//        System.out.println(Arrays.toString(rightProduct));
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = leftProduct[i] * rightProduct[i];
//        }
//        return res;

        // TC O(n) SC O(1)
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        int right = 1;
        for (int i = 1; i < n;i++) {
            res[i] = res[i - 1] * nums[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = res[i] * right;
            right *= nums[i];
        }
        return res;
    }
}
