package com.vinit.dsalgo.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumTwo40 {

    public static void combination(int[] nums, int n) {

        List<List<Integer>> result = new ArrayList<>();
        getSubset(0, nums, new ArrayList<Integer>(), 0, result, n);
        result.stream().forEach(e -> System.out.println(Collections.singletonList(e)));
    }

    private static void getSubset(int index, int[] nums, List<Integer> currList, int currSum, List<List<Integer>> result, int n) {
        if (currSum > n) return;
        if (currSum == n ) {
            result.add(new ArrayList<>(currList));
        }
        if (currSum > 9 ) return;
        for (int i = index; i < nums.length; i++) {
            currList.add(nums[i]);
            getSubset(i + 1, nums, currList, currSum + nums[i], result, n);
            currList.remove(currList.size() - 1);
        }
    }
    public static void main(String[] args) {
        combination(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
