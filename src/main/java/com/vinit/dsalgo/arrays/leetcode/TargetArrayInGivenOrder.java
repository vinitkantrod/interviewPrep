package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetArrayInGivenOrder {

    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> temp = new ArrayList<>(index.length);
        for(int i = 0; i < index.length; i++) {
            temp.add(index[i], nums[i]);
        }
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
}
