package com.vinit.dsalgo.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        int m = nums1.length;
        int[] arr = new int[m];
        Arrays.fill(arr, -1);
        for (int i = 0; i < m; i++) {
            int n = nums1[i];
            int idx = map.get(n);
            while (idx < nums2.length) {
                if (nums2[idx] > n) {
                    arr[i] = nums2[idx];
                    break;
                }
                idx++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(n1, n2)));
    }
}
