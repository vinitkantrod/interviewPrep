package com.vinit.dp.mergeIntervals;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        // Catalyn product
//        long C = 1;
//        for (int i = 0; i < n; ++i) {
//            C = C * 2 * (2 * i + 1) / (i + 2);
//        }
//        return (int) C;
        int[] G = new int[n  + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[i - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
