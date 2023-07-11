package com.vinit.dsalgo.searching.leetcode;

public class FindPeakElement162 {

    public static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public static int search(int[] nums, int l, int r) {
        System.out.println("l: " + l + ", r: " + r);
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        System.out.println("mid: " + mid);
        System.out.println(nums[mid] + " > " + nums[mid + 1]);
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,1};
        System.out.println(findPeakElement(n));
    }
}
