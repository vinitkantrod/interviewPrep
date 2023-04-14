package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KWeakestRowInMatrix1337 {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] temp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int soldierCount = 0;
            for (int j = 0; j < mat[0].length; j++) {
                soldierCount += mat[i][j] == 1 ? 1 : 0;
            }
            temp[i] = new int[]{i, soldierCount};
        }
        Arrays.sort(temp, (a,b) -> Integer.compare(a[1], b[1]));
        int[] res = new int[k];
        for (int x = 0; x < k; x++) {
            res[x] = temp[x][0];
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
