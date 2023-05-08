package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class HIndex274 {

    public static int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int maxHIndex = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + "-" + (n - i));
            System.out.println(", c: " + citations[i]);
            if ((n - i) >= citations[i]) maxHIndex = citations[i];
            else {
                maxHIndex = Math.max(maxHIndex, (n - i));
                break;
            }
        }
        return maxHIndex;
    }

    public static void main(String[] args) {
//        int[] c = {3,0,6,1,5};
//        int[] c = {1,3,1};
        int[] c = {1,1,2,3};
        System.out.println(hIndex(c));
    }
}
