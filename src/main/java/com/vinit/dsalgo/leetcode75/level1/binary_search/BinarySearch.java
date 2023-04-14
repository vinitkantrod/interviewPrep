package com.vinit.dsalgo.leetcode75.level1.binary_search;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if (low > high) return -1;
        return bnSearch(nums, target, low, high);
    }

    public static int bnSearch(int[] nums, int target, int low, int high) {
        System.out.println(low + " - " + high);
        if (high >= low) {
            int mid = low + ((high - low) / 2);
            System.out.println("mid: " + mid);
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) return bnSearch(nums, target, low, mid-1);
            else return bnSearch(nums, target, mid + 1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
