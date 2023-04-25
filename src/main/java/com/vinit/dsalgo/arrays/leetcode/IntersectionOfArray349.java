package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfArray349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        Set<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
//        System.out.println(n1);
//        System.out.println(n2);
//        n1.retainAll(n2);
//        System.out.println(n1);
//        System.out.println(n2);
//        int[] setArr = new int[n1.size()];
//        int j = 0;
//        for (int i : n1) {
//            setArr[j++] = i;
//        }
//        return setArr;

        // LC code without sorting
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        //Removed Duplicates using Hashset
        Set<Integer> Main_Set = new HashSet<>();
        for (Integer var : set1) {
            if (set2.contains(var)) {
                Main_Set.add(var);
            }
        }
        int[] arr = new int[Main_Set.size()];
        int j = 0;
        for (Integer val : Main_Set) {
            arr[j] = val.intValue();
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] n1 = {1,2,2,1}; int[] n2 = {2,2};
        int[] n1 = {4,9,5}; int[] n2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(n1, n2)));
    }
}
