package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class SquareOfSortedArray977 {

    public static int[] sortedSquares(int[] nums) {
        // Beats 10% TC
        // O(NLogN) TC || O(1) SC || Auxillary SC O(Log N) in java (uses variation of QuickSort)
//        return Arrays.stream(nums).map(x -> x*x).sorted().toArray();

        // O(N) TC || O(N) SC
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

}
