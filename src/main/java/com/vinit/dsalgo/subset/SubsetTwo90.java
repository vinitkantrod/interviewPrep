package com.vinit.dsalgo.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetTwo90 {

    public static void subset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        getSubset(0, nums, new ArrayList<Integer>(), res);
        for (List<Integer> l : res) {
            System.out.println(Collections.singletonList(l));
        }
    }
    private static void getSubset(int index, int[] nums, List<Integer> currList, List<List<Integer>> res) {
        res.add(new ArrayList<>(currList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) continue;;
            int currNum = nums[i];
            currList.add(currNum);
            getSubset(i + 1, nums, currList, res);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        subset(new int[]{2,1,2});
    }
}
