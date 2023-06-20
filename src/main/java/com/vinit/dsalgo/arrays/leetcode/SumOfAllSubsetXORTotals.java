package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfAllSubsetXORTotals {

    public static int total;
    public static int subsetXORSum(int[] nums) {
        subset(nums,0,0,nums.length);
        return total;
    }
    public static void subset(int[] arr,int prev_xor,int start,int len){
        for(int i=start;i<len;i++){
            int temp=prev_xor^arr[i];
            total+=temp;
            subset(arr,temp,i+1,len);
        }
    }
    public static void allSubset(int[] nums, int index, List<List<Integer>> list, List<Integer> tempList) {
        if (index == nums.length) return;
        list.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[index]);
            allSubset(nums, i + 1, list, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] n = {5,1,6};
        System.out.println(subsetXORSum(n));
    }
}
