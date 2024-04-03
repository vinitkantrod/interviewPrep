package com.vinit.dsalgo.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumThree216 {

    public static void combination(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        getSubset(0, nums, new ArrayList<Integer>(), 0, result, k, n);
        result.stream().forEach(e -> System.out.println(Collections.singletonList(e)));
    }

    private static void getSubset(int index, int[] nums, List<Integer> currList, int currSum, List<List<Integer>> result, int k, int n) {
        if (currSum > n || currList.size() > k) return;
        if (currSum == n && currList.size() == k) {
            result.add(new ArrayList<>(currList));
        }
        if (currSum > 9 ) return;
        for (int i = index; i < nums.length; i++) {
            currList.add(nums[i]);
            getSubset(i + 1, nums, currList, currSum + nums[i], result, k, n);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        combination(3, 9);
    }
}
