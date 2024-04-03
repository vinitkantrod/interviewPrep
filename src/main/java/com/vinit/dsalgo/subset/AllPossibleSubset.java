package com.vinit.dsalgo.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleSubset {

    public static List<List<Integer>> allSubset(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <=n; i++) {
            nums[i - 1] = i;
        }
        getSubset(0, nums, new ArrayList<Integer>(), res);
        for (List<Integer> l : res) {
            System.out.println(Collections.singletonList(l));
        }
        return res;
    }

    private static void getSubset(int index, int[] nums, List<Integer> currList, List<List<Integer>> res) {
        res.add(new ArrayList<>(currList));
        for (int i = index; i < nums.length; i++) {
            int currNum = nums[i];
            currList.add(currNum);
            getSubset(i + 1, nums, currList, res);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        allSubset(3);
    }
}
