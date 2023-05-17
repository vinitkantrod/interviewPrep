package com.vinit.dsalgo.graphs.leetcode;

import java.util.Arrays;

public class FindTheCelebrity277 {

    public static boolean knows(int a, int b) {
        return true;
    }
    public static int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i, n)) {
                return i;
            }
        }
        return -1;
    }

    public static Boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findCelebrity(5));
    }
}
