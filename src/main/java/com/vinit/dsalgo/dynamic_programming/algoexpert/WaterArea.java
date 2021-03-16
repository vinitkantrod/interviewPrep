package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;

public class WaterArea {

    public static int waterArea(int[] heights) {
        int leftHeightMax = 0;
        int[] maxes = new int[heights.length];
        for (int i = 0; i < heights.length; i++) maxes[i] = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            maxes[i] = leftHeightMax;
            leftHeightMax = Math.max(height, leftHeightMax);
        }
        System.out.println(Arrays.toString(maxes));
        int rightHeightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            int minHeigth = Math.min(maxes[i], rightHeightMax);
            if (height < minHeigth)
                maxes[i] = minHeigth - height;
            else
                maxes[i] = 0;
            rightHeightMax = Math.max(height, rightHeightMax);
        }
        System.out.println(Arrays.toString(maxes));
        int maxWater = 0;
        for (int i = 0; i < maxes.length; i++) maxWater += maxes[i];
        return maxWater;
    }
    public static void main(String args[]) {
        int[] w = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterArea(w));
    }
}
