package com.vinit.dsalgo.graphs.leetcode;

import java.util.Arrays;

public class NumberOfProvinces547 {

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int noOfProvinces = 0;
        Boolean[] seen = new Boolean[n];
        Arrays.fill(seen, false);
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(i, seen, isConnected);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
    }
    public static void dfs(int city, Boolean[] seen, int[][] isConnected) {
        seen[city] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (i != city && isConnected[city][i] == 1 && !seen[i]) {
                dfs(i, seen, isConnected);
            }
        }
    }
    public static void main(String[] args) {
        int[][] c = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(c));
    }
}
