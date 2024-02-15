package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) return;
        int i = 0, j = k;
        while (j < len) {
            j++;
            i++;
        }
        int[] newArr = new int[len];
        for (int x = i; x < len; x++) newArr[x - i] = nums[x];
        for (int y = k; y < len; y++) newArr[y] = nums[y - k];
        for (i = 0; i < len; i++) nums[i] = newArr[i];
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4,5,6,7};
        rotate(n, 3);
    }
}
