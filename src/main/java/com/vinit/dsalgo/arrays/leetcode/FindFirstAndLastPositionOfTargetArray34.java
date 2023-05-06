package com.vinit.dsalgo.arrays.leetcode;

public class FindFirstAndLastPositionOfTargetArray34 {

    public static int[] searchRange(int[] nums, int target) {
        int firstOccurance = findBound(nums, target, true);
        if (firstOccurance == -1) return new int[]{-1, -1};
        int secondOccurance = findBound(nums, target, false);
        return new int[]{firstOccurance, secondOccurance};
    }

    public static int findBound(int[] nums, int target, Boolean isFirst) {
        int end = nums.length - 1;
        int begin = 0;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        begin = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
