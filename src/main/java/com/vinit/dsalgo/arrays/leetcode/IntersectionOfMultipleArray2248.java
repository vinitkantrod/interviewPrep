package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class IntersectionOfMultipleArray2248 {

    public static List<Integer> intersection(int[][] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<Set<Integer>> intSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < nums[i].length; j++) {
                s.add(nums[i][j]);
            }
            intSet.add(s);
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> resSet = new HashSet<>();
        resSet = intSet.get(0);
        for (int i = 1; i < intSet.size(); i++) {
            Set<Integer> temp = new HashSet<>();
            for (int x : resSet) temp.add(x);
            Set<Integer> current = intSet.get(i);
            for (int l : temp) {
                if (!current.contains(l)) resSet.remove(l);
            }
        }
        for (int i : resSet) {
            res.add(i);
        }
        res.sort((a,b) -> Integer.compare(a, b));
        return res;
    }
    public static void main(String[] args) {
        int[][] n = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(Arrays.asList(intersection(n)));
    }
}
