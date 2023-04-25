package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDiffOfTwoArray2215 {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        for (int i : nums1) n1.add(i);
        Set<Integer> n2 = new HashSet<>();
        for (int i : nums2) n2.add(i);
        Set<Integer> Main_Set = new HashSet<>();
        for (Integer var : n1) {
            if (n2.contains(var)) {
                Main_Set.add(var);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (int i : n1) {
            if (!Main_Set.contains(i)) res1.add(i);
        }
        for (int i : n2) {
            if (!Main_Set.contains(i)) res2.add(i);
        }
        res.add(res1);
        res.add(res2);
        return res;
    }

    public static void main(String[] args) {

    }
}
