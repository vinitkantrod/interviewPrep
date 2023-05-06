package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertAnArrayInto2DArray2610 {

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ll = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (ll.size() > 0) {
            List<Integer> lst = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            List<Integer> copy = new ArrayList<>();
            for (int i : ll) {
                if (!set.contains(i)) {
                    set.add(i);
                    lst.add(i);
                } else {
                    copy.add(i);
                }
            }
            ll = new ArrayList<>(copy);
            res.add(lst);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {1,3,4,1,2,3,1};
        System.out.println(findMatrix(n));
    }
}
