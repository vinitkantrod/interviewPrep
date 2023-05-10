package com.vinit.dsalgo.graphs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheTownJudge997 {

    public static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        for (int i = 0; i < trust.length; i++) {
            int u = trust[i][0];
            arr[u - 1] = -1;
            int v = trust[i][1];
            if (arr[v-1] != -1) {
                arr[v - 1]++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n - 1) return i + 1;
        }
        return -1;
    }
}
