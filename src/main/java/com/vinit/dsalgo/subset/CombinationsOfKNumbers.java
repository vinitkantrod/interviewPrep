package com.vinit.dsalgo.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsOfKNumbers {

    public static void combinations(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i < n + 1; i++) {
            nums[i - 1] = i;
        }
        List<List<Integer>> ans = new ArrayList<>();
        getSubSets(0, nums, new ArrayList<Integer>(), ans, k);
        for (List<Integer> l : ans) {
            System.out.println(Collections.singletonList(l));
        }
    }

    private static void getSubSets(int index, int[] nums, ArrayList<Integer> currList, List<List<Integer>> ans, int k) {
        if (currList.size() == k) {
            ans.add(new ArrayList<>(currList));
        }
        for (int i = index; i < nums.length; i++) {
            currList.add(nums[i]);
            getSubSets(i + 1, nums, currList, ans, k);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinations(4,2);
    }
}
