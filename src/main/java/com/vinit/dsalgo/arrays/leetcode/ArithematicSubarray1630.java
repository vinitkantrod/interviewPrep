package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArithematicSubarray1630 {

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        Boolean[] result = new Boolean[l.length];
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
//            List<Integer> sortedSubArr = getSortedArray(nums, left, right);
        }
        return new ArrayList<>();
    }

//    public static List<Integer> getSortedArray(int[] nums, int l, int r) {
//        int m = r - l
//    }
    public static void main(String[] args) {

    }
}
