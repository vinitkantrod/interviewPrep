package com.vinit.dsalgo.backtrack.leetcode;

import java.util.*;

public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < candidates.length; i++) set.add(candidates[i]);
//        int[] num = new int[set.size()];
//        int j = 0;
//        for (int i : set) num[j++] = i;
//        Arrays.sort(num);
//        findCombination(num, ans, temp, 0, target);
//        return ans;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] num, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < num.length; i++) {
                tempList.add(num[i]);
                backtrack(list, tempList, num, remain - num[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public void findCombination(int[] num, List<List<Integer>> ans,
                                List<Integer> temp, int index, int sum) {
        if (sum == 0) {
            List<Integer> t = new ArrayList<>(temp);
            ans.add(t);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (sum - num[i] >= 0) {
                temp.add(temp.size(), num[i]);
                findCombination(num, ans, temp, i, sum - num[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
