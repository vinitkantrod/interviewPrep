package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class IntersectionOfThreeSortedArray1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i]))
                set2.add(arr2[i]);
        }
        Set<Integer> set3 = new TreeSet<>();
        for (int i = 0; i < arr3.length; i++) {
            if (set2.contains(arr3[i]))
                set3.add(arr3[i]);
        }
        List<Integer> l = new ArrayList<>();
        for (int i : set3) {
            l.add(i);
        }
        return l;

    }
}
