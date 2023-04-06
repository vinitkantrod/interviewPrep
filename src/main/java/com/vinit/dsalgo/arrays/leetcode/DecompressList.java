package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class DecompressList {

    public static int[] decompressRLElist(int[] nums) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        int i = 0;
//        while ((2 * i + 1) < nums.length) {
//            int freq = nums[2 * i];
//            int val = nums[2 * i + 1];
//            for (int j = 0; j < freq; j++) {
//                temp.add(val);
//            }
//            i++;
//        }
//        int[] res = temp.stream().mapToInt(Integer::intValue).toArray();
//        return res;
        int len = 0;
        for (int i = 0; i < nums.length; i+=2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int j = 0;
        for (int i = 0; i < nums.length; i+=2) {
            Arrays.fill(res, j, j + nums[i], nums[i + 1]);
            j += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
//        int[] nums = {1,1,2,4};
        int[] nums = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(decompressRLElist(nums)));
    }

}
