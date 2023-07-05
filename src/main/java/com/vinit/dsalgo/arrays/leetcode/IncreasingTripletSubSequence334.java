package com.vinit.dsalgo.arrays.leetcode;

public class IncreasingTripletSubSequence334 {
    public static boolean increasingTriplet(int[] nums) {
        int[] indices = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val <= indices[0]) {
                indices[0] = val;
            } else if (val <= indices[1]) {
                indices[1] = val;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] n = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(n));
    }
}
