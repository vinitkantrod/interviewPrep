package com.vinit.dsalgo.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSimiliarItems2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[][] res = new int[1001][2];
        for (int[] i : items1) {
            int idx = i[0];
            res[idx] = new int[] {i[0], i[1]};
        }
        for (int[] i : items2) {
            int idx = i[0];
            int[] e = res[idx];
            if (e[1] != 0) {
                e[1] = e[1] + i[1];
                res[idx] = new int[]{e[0], e[1]};
            } else {
                res[idx] = new int[]{i[0], i[1]};
            }
        }
        List<List<Integer>> tempRes = new ArrayList<>();
        for (int i =0; i < res.length; i++) {
            if (res[i][1] > 0) tempRes.add(new ArrayList<>(Arrays.asList(res[i][0], res[i][1])));
        }
        return tempRes;
    }
}
