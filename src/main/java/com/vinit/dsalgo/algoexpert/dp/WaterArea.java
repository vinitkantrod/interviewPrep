package com.vinit.dsalgo.algoexpert.dp;

public class WaterArea {

    public static int waterArea(int[] heights) {
        // Write your code here.
        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        int surfaceArea = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, heights[left]);
                surfaceArea += leftMax - heights[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, heights[right]);
                surfaceArea += rightMax - heights[right];
            }
        }
        return surfaceArea;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterArea(a));
    }
}
