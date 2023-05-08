package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class RotateArray189 {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int i = 0;
        int j = i + k;
        while (j < nums.length) {
            i++;
            j++;
        }
//        System.out.println(i + " - " + j);
        int[] newN = new int[nums.length];
        for (int x = i; x < nums.length; x++) {
            newN[x - i] = nums[x];
        }
        for (int y = 0; y < i; y++) {
            newN[y + k] = nums[y];
        }
        for (i = 0; i < newN.length; i++) {
            nums[i] = newN[i];
        }

        System.out.println(Arrays.toString(newN));
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6,7};
        rotate(n, 3);
    }
}
