package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRange228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] <= 1) {
                i++;
            }
            if (start != nums[i]) {
                range.add(start + "->" + nums[i]);
            } else {
                range.add(String.valueOf(start));
            }
        }
        return range;
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,5,6,11};
        System.out.println(Arrays.asList(summaryRanges(n)));
    }
}
