package com.vinit.dsalgo.backtrack.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumThree216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(n, k, combination, 0, result);
        return result;
    }
    public void backtrack(
            int remain,
            int k,
            LinkedList<Integer> combination,
            int next_start,
            List<List<Integer>> result
    ) {
        if (combination.size() == k && remain == 0) {
            result.add(new ArrayList<>(combination));
            return;
        } else if (remain < 0 || combination.size() == k) {
            return;
        }
        for (int i = next_start; i < 9; i++) {
            combination.add(i + 1);
            backtrack(remain - i - 1, k, combination, i + 1, result);
            combination.removeLast();
        }
    }
}
