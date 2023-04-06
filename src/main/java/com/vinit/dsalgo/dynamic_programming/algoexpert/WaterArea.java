package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;
import java.util.Map;

public class WaterArea {

//    public static int waterArea(int[] heights) {
//        int leftHeightMax = 0;
//        int[] maxes = new int[heights.length];
//        for (int i = 0; i < heights.length; i++) maxes[i] = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int height = heights[i];
//            maxes[i] = leftHeightMax;
//            leftHeightMax = Math.max(height, leftHeightMax);
//        }
//        System.out.println(Arrays.toString(maxes));
//        int rightHeightMax = 0;
//        for (int i = heights.length - 1; i >= 0; i--) {
//            int height = heights[i];
//            int minHeigth = Math.min(maxes[i], rightHeightMax);
//            if (height < minHeigth)
//                maxes[i] = minHeigth - height;
//            else
//                maxes[i] = 0;
//            rightHeightMax = Math.max(height, rightHeightMax);
//        }
//        System.out.println(Arrays.toString(maxes));
//        int maxWater = 0;
//        for (int i = 0; i < maxes.length; i++) maxWater += maxes[i];
//        return maxWater;
//    }

    public static int waterArea(int[] heights) {
        // O(n) Time | O(n) space
//        int[] maxes = new int[heights.length];
//        int[] leftMaxArr = new int[heights.length];
//        int[] rightMaxArr = new int[heights.length];
//        int maxSum = 0;
//        int leftMax = Integer.MIN_VALUE;
//        for (int i = 0; i < heights.length; i++) {
//            if (heights[i] > leftMax) {
//                leftMax = heights[i];
//            }
//            leftMaxArr[i] = leftMax;
//        }
//        int rightMax = Integer.MIN_VALUE;
//        for (int i = heights.length - 1; i >= 0; i--) {
//            if (heights[i] > rightMax) {
//                rightMax = heights[i];
//            }
//            rightMaxArr[i] = rightMax;
//        }
//        System.out.println(Arrays.toString(leftMaxArr));
//        System.out.println(Arrays.toString(rightMaxArr));
//        for (int i = 0; i < heights.length; i++) {
//            maxes[i] = Math.abs(heights[i] - Math.min(leftMaxArr[i], rightMaxArr[i]));
//            maxSum += maxes[i];
//        }
//        System.out.println(Arrays.toString(maxes));
//
//        return maxSum;
//
        // O(n) Time | O(1) space
        if (heights.length == 0) return 0;
        int leftIdx = 0;
        int rightIdx = heights.length - 1;
        int leftMax = heights[leftIdx];
        int rightMax = heights[rightIdx];
        int surfaceArea = 0;
        while (leftIdx < rightIdx) {
            if (leftMax < rightMax) {
                leftIdx++;
                leftMax = Math.max(leftMax, heights[leftIdx]);
                surfaceArea += leftMax - heights[leftIdx];
            } else {
                rightIdx--;
                rightMax = Math.max(rightMax, heights[rightIdx]);
                surfaceArea += rightMax - heights[rightIdx];
            }
        }
        return surfaceArea;
    }
    public static void main(String args[]) {
        int[] w = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterArea(w));
    }
}
