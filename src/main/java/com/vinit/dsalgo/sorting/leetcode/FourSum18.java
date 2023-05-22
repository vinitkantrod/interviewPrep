package com.vinit.dsalgo.sorting.leetcode;

import java.util.*;

public class FourSum18 {

    public static class Pair {
        int first;
        int second;

        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if(sum == target){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    }
                    else if(sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] n = {1,0,-1,0,-2,2};
        System.out.println(Arrays.asList(fourSum(n, 0)));
    }
}
