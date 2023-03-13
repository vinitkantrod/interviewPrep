package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodPairs {


    public static int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (!hashMap.containsKey(nums[idx])) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(idx);
                hashMap.put(nums[idx], arrayList);
            } else {
                ArrayList<Integer> arrayList = hashMap.get(nums[idx]);
                pairCount += arrayList.size();
                arrayList.add(idx);
                hashMap.put(nums[idx], arrayList);
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3,1,1,1,3,3,3,3,3,3,2};
//        int[] nums = {1,1,1,1};
        System.out.println(numIdenticalPairs(nums));
    }
}
