package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {
        int n = nums.length, cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2 && nums[i] * 3 < target; i++)
            for (int l = i + 1, r = n - 1; l < r;)
                if (nums[i] + nums[l] + nums[r] < target)
                    cnt += r - l++; //all r in (l, r] will also satisfy the condition
                else
                    r--;
        return cnt;
    }

    public static void main(String args[]) {
//        int[] num = {-2, 0, 1, 3};
        int[] num = {3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1};
        System.out.println(threeSumSmaller(num, 3));
    }
}
