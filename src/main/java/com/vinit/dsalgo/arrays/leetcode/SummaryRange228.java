package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRange228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int startCounter = nums[0];
        startCounter++;
        int startValue = nums[0];
        String s = String.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (startCounter != nums[i]) {
                startCounter = nums[i];
                list.add(s);
                s = String.valueOf(nums[i]);
            } else {
                if (startValue != nums[i]) {

                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] n = {1};
        System.out.println(Arrays.asList(summaryRanges(n)));
    }
}
