package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class TrappingRainWater42 {

    public static int trap(int[] height) {
        int n = height.length;
        int[] leftHeight = new int[n];
        int maxLeftHeight = 0;
        System.out.println("heights: " + Arrays.toString(height));
        for (int i = 0; i < n; i++) {
            if (height[i] > maxLeftHeight) maxLeftHeight = height[i];
            leftHeight[i] = maxLeftHeight - height[i];
        }
        System.out.println("leftHeight: " + Arrays.toString(leftHeight));
        int[] rightHeight = new int[n];
        int maxRightHeight = 0;
        for (int i = n- 1; i >= 0; i--) {
            if (height[i] > maxRightHeight) maxRightHeight = height[i];
            rightHeight[i] = maxRightHeight - height[i];
        }
        System.out.println("rightHeight: " + Arrays.toString(rightHeight));
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftHeight[i], rightHeight[i]);
        }
        return totalWater;
    }

    public static void main(String[] args) {
//        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights = {4,2,0,3,2,5};
        System.out.println(trap(heights));
    }
}
