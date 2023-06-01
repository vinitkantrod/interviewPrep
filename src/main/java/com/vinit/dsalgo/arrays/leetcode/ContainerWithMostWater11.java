package com.vinit.dsalgo.arrays.leetcode;

public class ContainerWithMostWater11 {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
//            System.out.println(width+"-"+maxArea + "-" + height[left] + "-" + height[right]+"-"+height[right] * width);
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }
}
