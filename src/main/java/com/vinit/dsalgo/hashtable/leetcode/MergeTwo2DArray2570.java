package com.vinit.dsalgo.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwo2DArray2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> temp = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int[] x = nums1[i];
            int[] y = nums2[j];
            if (x[0] == y[0]) {
                temp.add(new ArrayList<>(Arrays.asList(x[0], x[1] + y[1])));
                i++;
                j++;
            } else if (x[0] < y[0]) {
                temp.add(new ArrayList<>(Arrays.asList(x[0], x[1])));
                i++;
            } else {
                temp.add(new ArrayList<>(Arrays.asList(y[0], y[1])));
                j++;
            }
        }
        while (i < m) {
            temp.add(new ArrayList<>(Arrays.asList(nums1[i][0], nums1[i][1])));
            i++;
        }
        while (j < n) {
            temp.add(new ArrayList<>(Arrays.asList(nums1[j][0], nums1[j][1])));
            j++;
        }
        int k = 0;
        int[][] res = new int[temp.size()][2];
        for (int l = 0; l < temp.size(); l++) {
            res[k] = new int[]{temp.get(l).get(0), temp.get(l).get(1)};
            k++;
        }
        return res;
    }
}
